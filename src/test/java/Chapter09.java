import ch09.Employee;
import ch09.IoUtils;
import ch09.Point;
import ch09.PointDisk;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Chapter09 {

	@Test
	public void ex01() throws IOException {
		Path source = Paths.get("docs/ch09/music.mp3");
		Path target = Paths.get("docs/ch09/music.target.mp3");

		try (InputStream in = Files.newInputStream(source);
			 OutputStream out = Files.newOutputStream(target);) {
			IoUtils.copyWithTemp(in, out);
		}
	}

	@Test
	public void ex02() throws IOException {
		Path source = Paths.get("docs/ch09/alice.txt");
		Path target = Paths.get("docs/ch09/alice.toc");

		// 파일을 한줄씩 읽으면서 라인 번호를 가져올 수 있는 java.io.LineNumberReader
		try (LineNumberReader reader = new LineNumberReader(Files.newBufferedReader(source, StandardCharsets.UTF_8));) {
			// Map<라인번호, List<단어>> 로 변환한다.
			Map<Integer, List<String>> mapFrom = reader.lines()
					// 비어있는 라인 필터
					.filter(v -> !v.trim().isEmpty())
					// 모두 소문자로 변경
					.map(String::toLowerCase)
					// Map<라인번호, List<문자>> 으로 변경
					.collect(Collectors.toMap(
							// 키를 라인 번호로 사용
							t -> reader.getLineNumber(),
							// 값를 String -> List<String> 으로 사용 (빈문자 필터, 단어 중복 제거)
							t -> Arrays.stream(t.split("\\PL+")).filter(v -> !v.trim().isEmpty()).distinct()
									.collect(Collectors.toList())));

			// Map<라인번호, List<단어>> 를 Map<단어, List<라인번호>> 로 변경한다.
			Map<String, List<Integer>> mapTo = mapFrom.entrySet().stream()
					// Map<라인번호, List<단어> -> Stream<Map<단어, 라인번호>> 로 쪼갠다.
					.flatMap(e -> e.getValue().stream().map(v -> new AbstractMap.SimpleImmutableEntry<>(e.getKey(), v)))
					// 단어로 그룹핑 (키 = 단어, 값 = List<라인번호>)
					.collect(Collectors.groupingBy(AbstractMap.SimpleImmutableEntry::getValue,
							Collectors.mapping(AbstractMap.SimpleImmutableEntry::getKey, Collectors.toList())));

			// 파일로 출력
			try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(target, StandardCharsets.UTF_8));) {
				mapTo.forEach((k, v) -> {
					pw.println(k + " = " + v.stream().map(Object::toString).collect(Collectors.joining(", ")));
				});
			}
		}

	}

	// 텍스트를 담고 잇는 파일을 읽은 후 단어 대부분이 영어로 되어 있다고 가정하고 인코딩이 아스키, ISO-8859-1, UTF-8, UTF-16 중 어느 것인지 추측하는 프로그램을 작성하라.
	// UTF-16일 때는 사용한 바이트 순서도 추측해야 한다.
	@Test
	public void ex03() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch09/encode.txt"), StandardCharsets.UTF_8);) {
			reader.lines().forEach(v -> {
				System.out.println(Arrays.toString(v.codePoints().toArray()));
			});

		}
	}

	@Test
	public void ex04a() throws IOException {
		try (Scanner scanner = new Scanner(Paths.get("docs/ch09/catalina.out"));) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
			}
		}
	}

	@Test
	public void ex04b() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch09/catalina.out"));) {
			String line = null;
			while ((line = reader.readLine()) != null) {

			}
		}
	}

	@Test
	public void ex04c() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch09/catalina.out"));) {
			reader.lines().forEach(v -> {

			});
		}
	}

	@Test
	public void ex06() throws IOException {
		Path path = Paths.get("docs/ch09/mario.bmp");

		try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw");) {
			// BMP 파일인지 검증
			int header = raf.readUnsignedShort();
			if (header != 0x424D) {
				System.err.println(path + " is not bitmap");
			}

			// 이미지 데이터의 위치를 찾는다.
			raf.seek(0x000A);
			int offset = raf.read() | (raf.read() << 8) | (raf.read() << 16) | (raf.read() << 24);

			// 1바이트씩 이동하면서 색 반전
			raf.seek(offset);
			int read = -1;
			while ((read = raf.read()) != -1) {
				raf.seek(raf.getFilePointer() - 1);
				raf.write(255 - read);
			}
		}
	}

	@Test
	public void ex08() throws IOException {
		// 압축할 대상 디렉터리
		Path path = Paths.get("D:\\develoment\\javaimpatient");
		// 만들어지는 zip 파일
		Path zipPath = Paths.get("D:\\ch09-ex08.zip");

		try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(zipPath));) {
			// 모든 하위 목록 가져옴
			try (Stream<Path> entries = Files.walk(path);) {
				entries.filter(p -> !Files.isDirectory(p)).forEach(p -> {
					try {
						out.putNextEntry(new ZipEntry(path.relativize(p).toString()));
						Files.copy(p, out);
						out.closeEntry();
					} catch (IOException e) {
						throw new UncheckedIOException(e);
					}
				});
			}
		}
	}

	@Test
	public void ex09() throws IOException {
		String http = "http://httpbin.org/basic-auth/user/passwd";
		String username = "user";
		String password = "passwd";

		String input = username + ":" + password;
		String encoding = Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));

		URL url = new URL(http);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Authorization", "Basic " + encoding);
		conn.connect();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));) {
			reader.lines().forEach(System.out::println);
		}

	}

	@Test
	public void ex10a() {
		// (a) find
		String s = "antop name 10.12 is aaa! antop is+33 -15";
		String regex = "[+-]?[0-9]+";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);

		List<Integer> list = new ArrayList<>();
		while (matcher.find()) {
			list.add(Integer.parseInt(matcher.group()));
		}

		System.out.println(list);
		// [10, 12, 33, -15]
	}

	@Test
	public void ex10b() {
		// (b) split
		String s = "antop name 10.12 is aaa! antop is+33 -15";
		String regex = "[^+\\-0-9]";

		Pattern pattern = Pattern.compile(regex);
		List<String> list = Arrays.stream(pattern.split(s)).filter(v -> !v.trim().isEmpty()).collect(Collectors.toList());

		System.out.println(list);
		// [10, 12, +33, -15]
	}

	// 11. 정규 표현식을 사용해 /home/cay/myfile.txt 같은 절대 경로 또는 상대 경로에서 디렉터리 경로 이름들(문자열의 배열), 파일 이름, 파일 확장자를 추출하라.
	@Test
	public void ex11() throws IOException {
		class FileInfo {
			// 디렉터리 경로 이름들
			private String[] directories;
			// 파일 이름
			private String name;
			// 확장자
			private String extension;

			@Override
			public String toString() {
				return "FileInfo{" + "directories=" + Arrays.toString(directories) + ", name='" + name + '\'' + ", extension='" + extension + '\'' + '}';
			}
		}
		// 찾을 루트 경로
		Path root = Paths.get(".");
		// OS 에서 사용하는 경로 구분자
		String separator = Pattern.quote(File.separator);
		// 디렉터리 경로 + 파일 정규 표현식
		Pattern pathPattern = Pattern.compile("(?<directory>([^+]+" + separator + ")+)(?<name>[^+]+$)");
		// 파일 이름 + 확장자 정규 표현식식
		Pattern fileNamePattern = Pattern.compile("(?<name>[^+]+)(?<ext>\\.[^.]+$)");

		try (Stream<Path> entries = Files.walk(root);) {
			List<FileInfo> result = entries
					// 파일만 걸러낸다.
					.filter(p -> !Files.isDirectory(p))
					// 파일 경로를 정규화 한다. (/home/antop/./doc/../app -> /home/antop/app)
					.map(p -> p.toAbsolutePath().normalize()).map(p -> {
						FileInfo f = new FileInfo();

						Matcher m1 = pathPattern.matcher(p.toString());
						if (m1.matches()) { // 디렉터리 + 파일명으로 분리
							String directory = m1.group("directory");
							String fileName = m1.group("name");

							// 디렉터리는 구분자로 분리
							String[] directories = directory.split(separator);
							f.directories = directories;

							// 파일명은 이름과 확장자로 분리
							Matcher m2 = fileNamePattern.matcher(fileName);
							if (m2.matches()) {
								f.name = m2.group("name");
								f.extension = m2.group("ext").substring(1);
							} else {
								f.name = fileName;
							}
						}

						return f;

					}).collect(Collectors.toList());

			// 출력
			result.forEach(System.out::println);
		}
	}

	@Test
	public void ex13() throws IOException {
		Employee source = new Employee("antop", 5000);
		System.out.println(source); // ch09.Employee@694f9431 {name='antop', salary=5000.0}

		try (ByteArrayOutputStream bas = new ByteArrayOutputStream();
			 ObjectOutputStream oos = new ObjectOutputStream(bas);) {
			oos.writeObject(source); // write

			try (ByteArrayInputStream bai = new ByteArrayInputStream(bas.toByteArray());
				 ObjectInputStream ois = new ObjectInputStream(bai);) {
				try {
					Employee target = (Employee) ois.readObject(); // read
					System.out.println(target); // ch09.Employee@4aa8f0b4 {name='antop', salary=5000.0}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}

		}
	}

	// 14. 인스턴스 변수로 x와 y가 포함된 직렬화 기능한 클래스 Point를 구현하라. Point 객체의 배열을 파일로 직렬화하는 프로그램과 해당 파일을 읽는 프로그램을 작성하라.
	@Test
	public void ex14() throws Exception {
		// create point object
		int size = 5;
		Random random = new Random();
		Point[] points = new Point[size];
		for (int i = 0; i < size; i++) {
			points[i] = new Point(random.nextInt(10), random.nextInt(10));
		}
		System.out.println("points = " + Arrays.toString(points));
		// points = [ch09.Point@f2a0b8e {x=0, y=6}, ch09.Point@593634ad {x=5, y=4}, ch09.Point@20fa23c1 {x=2, y=8}, ch09.Point@3581c5f3 {x=4, y=5}, ch09.Point@6aa8ceb6 {x=8, y=4}]

		// save to file
		PointDisk.save(Paths.get("D:\\points.txt"), points);
		// load from file
		Point[] loaded = PointDisk.load(Paths.get("D:\\\\points.txt"));

		System.out.println("points = " + Arrays.toString(loaded));
		// points = [ch09.Point@2c13da15 {x=0, y=6}, ch09.Point@77556fd {x=5, y=4}, ch09.Point@368239c8 {x=2, y=8}, ch09.Point@9e89d68 {x=4, y=5}, ch09.Point@3b192d32 {x=8, y=4}]
	}

}
