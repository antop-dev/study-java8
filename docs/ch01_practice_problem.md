#### 1. 정수를 읽어서 2진수, 8진수, 16진수로 출력하는 프로그램을 작성하라. 역수를 16진 부동소수점 수로 출력하라.

```java
// 정수
int n = 200;
// 2진수
String binary = Integer.toBinaryString(n);
// 8진수
String octal = Integer.toOctalString(n);
// 16진수
String hex = Integer.toHexString(n);

System.out.println("binary = " + binary);
System.out.println("octal = " + octal);
System.out.println("hex = " + hex);
```

```java
double n = 2;
// 역수
double inverse = 1 / n;
// 16진수 부동소수점
String hex = Double.toHexString(inverse);

System.out.println("n = " + n);
System.out.println("inverse = " + inverse);
System.out.println("hex = " + hex);
```

#### 2. 정수(양의 정수 또는 음의 정수)로 된 각도를 읽고 0~360도 사이의 값으로 정규화하는 프로그램을 작성하라. 먼저 % 연산자를 이용해 만들어본 다음. floorMod 메서드를 이용해 만들어본다.

```java
Random random = new Random();
int y = 360; // 0 ~ 359

int n = random.nextInt();
System.out.println("n = " + n);

int n1 = (n % y + y) % y;
System.out.println("n1 = " + n1);

int n2 = Math.floorMod(n, y);
System.out.println("n2 = " + n2);
```

#### 3. 조건 연산자만 사용해서 정수 세 개를 읽고 최대값을 출력하는 프로그램을 작성하라. Math.max를 사용해서 같은 프로그램을 작성하라.

```java
// 정수 3개
int n1 = 12;
int n2 = 9;
int n3 = 17;

int max = Integer.MIN_VALUE;
if (n1 > max) {
	max = n1;
}
if (n2 > max) {
	max = n2;
}
if (n3 > max) {
	max = n3;
}
// 17
System.out.println("max = " + max);
```

```java
// 정수 3개
int n1 = 157;
int n2 = 384;
int n3 = 95;

int max = Math.max(Math.max(n1, n2), n3);
// 384
System.out.println("max = " + max);
```

#### 4. double 타입인 양수 값 중 작은 값과 가장 큰 값을 출력하는 프로그램을 작성하라.

```java
double min = Math.nextUp(0);
double max = Math.nextDown(Double.MAX_VALUE);

System.out.println("min = " + min); // 1.401298464324817E-45
System.out.println("max = " + max); // 1.7976931348623155E308
```

#### 5. int의 최대값보다 큰 double을 int 타입으로 변환하면 무슨일이 일어나는가? 직접 시도해보자. [p39]

```
int의 최대값(2147483647)으로 설정 된다.
```

```java
double d = Double.MAX_VALUE;
int i = (int) d;

System.out.println("double = " + d); // 1.7976931348623157E308
System.out.println("integer = " + i); // 2147483647
```

#### 6. BigInteger를 사용해 팩토리얼 n! = 1 x 2 x ... x n 을 계산하는 프로그램을 작성하라. 그리고 프로그램을 이용해 1,000 팩토리얼을 계산하라.

```java
// 반복 횟수
int loop = 1000;

for (int n = 1 ; n <= loop ; n++) {
	BigInteger result = BigInteger.ONE;

	for (int j = 1 ; j <= n ; j++) {
		result = result.multiply(BigInteger.valueOf(j));
	}

	System.out.println(n + "! = " + result);
}
```

#### 7. 0~65,535 사이의 숫자 두개를 읽어서 short 변수에 저장한 후 int로 변환하지 않은 채 부호 없는 합계, 차이, 곱, 몱, 나머지를 계산하는 프로그램을 작성하라. [p30]

*문제를 이해 못함...*

int형 0&#126;65535를 short형 &#45;32768&#126;32765로 사용할 수 있다. **[p30]**

```
short min = -32768
short max = 32767

int: 32765 = short:  32765
int: 32766 = short:  32766
int: 32767 = short:  32767
int: 32768 = short: -32768
int: 32769 = short: -32767
int: 32770 = short: -32766
int: 65535 = short:     -1
```

```java
Random random = new Random();

int i1 = random.nextInt(65536);
int i2 = random.nextInt(65536);
short s1 = (short) i1;
short s2 = (short) i2;

{
	System.out.println("-- integer --");
	System.out.println("i1 = " + i1);
	System.out.println("i2 = " + i2);

	int add = i1 + i2;
	int sub = i1 - i2;
	int mul = i1 * i2;
	int div = i1 / i2;
	int rem = i1 % i2;

	System.out.println("더하기 = " + add);
	System.out.println("빼기   = " + sub);
	System.out.println("곱하기 = " + mul);
	System.out.println("나누기 = " + div);
	System.out.println("나머지 = " + rem);
}

{
	System.out.println("-- short --");
	System.out.println("s1 = " + s1);
	System.out.println("s2 = " + s2);

	short add = (short) (s1 + s2);
	short sub = (short) (s1 - s2);
	short mul = (short) (s1 * s2);
	short div = (short) (s1 / s2);
	short rem = (short) (s1 % s2);

	System.out.println(String.format("더하기 = %6s, int = %d", add, Short.toUnsignedInt(add)));
	System.out.println(String.format("빼기   = %6s, int = %d", sub, Short.toUnsignedInt(sub)));
	System.out.println(String.format("곱하기 = %6s, int = %d", mul, Short.toUnsignedInt(mul)));
	System.out.println(String.format("나누기 = %6s, int = %d", div, Short.toUnsignedInt(div)));
	System.out.println(String.format("나머지 = %6s, int = %d", rem, Short.toUnsignedInt(rem)));
}
```

```
-- integer --
i1 = 14117
i2 = 50453
더하기 = 64570
빼기   = -36336
곱하기 = 712245001
나누기 = 0
나머지 = 14117

-- short --
s1 = 14117
s2 = -15083
더하기 =   -966, int = 64570
빼기   =  29200, int = 29200
곱하기 =   -247, int = 65289
나누기 =      0, int = 0
나머지 =  14117, int = 14117
```

#### 8. 문자열을 읽어서 비어 있지 않는 부분 문자열을 모두 출력하는 프로그램을 작성하라.

```java
String s = "Slack brings all your communication together in one place. It's real-time messaging, archiving and search for modern teams.";
System.out.println(s);

String result = "";

for (char c : s.toCharArray()) {
	if (c != ' ') {
		result += c;
	}
}
// Slackbringsallyourcommunicationtogetherinoneplace.It'sreal-timemessaging,archivingandsearchformodernteams.
System.out.println(result);
```

#### 9. 1.5.3 문자열 비교에는 s.equals(t) 지만 s!=t 인 두 문자열 s와 t를 비교하는 예제가 있다. 부분 문자열을 사용하지 않는 다른 예를 제시하라. [p45]

```java
String s1 = "antop";
String s2 = "antop";
String s3 = new String("antop");

System.out.println(s1 == s2); // true
System.out.println(s1.equals(s2)); // true
System.out.println(s1 == s3); // false
System.out.println(s1.equals(s3)); // true
```

[String Pool](https://www.youtube.com/watch?v=hdgRaJ-G5DE)

#### 10. 임의의 long 값을 생성한 후 36진수로 출력해서 임의의 글자와 숫자로 구성된 문자열을 만들어내는 프로그램을 작성하라.

```java
Random random = new Random();
// long
long n = random.nextLong();
// to 36
String conv = Long.toString(n, 36);

System.out.println(n + " (16) to " + conv + " (36)");
```

#### 11. 텍스트 한줄을 읽고 아스키 외의 모든 문자를 유니코드 값과 함께 출력하는 프로그램을 작성하라. [p43]

```java
// 문자열
String word = "Java™ 에서 유니코드를 처리합시다. Let's go!";
System.out.println("string = " + word);
// char[] 로 변환
char[] chars = word.toCharArray();
// [J, a, v, a, ™,  , 에, 서,  , 유, 니, 코, 드, 를,  , 처, 리, 합, 시, 다, .,  , L, e, t, ', s,  , g, o, !]
System.out.println(Arrays.toString(chars));

// 아스키 코드를 제외하고 16진수 유니코드로 변환
String[] unicode = new String[chars.length];
for (int i = 0; i < chars.length; i++) {
	char c = chars[i];
	String s = String.valueOf(c);
	unicode[i] = c > 0 && c <= 127 ? s : String.format("\\u%04x", Integer.parseInt(Integer.toHexString(c), 16));
}

// [J, a, v, a, \u2122,  , \uc5d0, \uc11c,  , \uc720, \ub2c8, \ucf54, \ub4dc, \ub97c,  , \ucc98, \ub9ac, \ud569, \uc2dc, \ub2e4, .,  , L, e, t, ', s,  , g, o, !]
System.out.println(Arrays.toString(unicode));
```

#### 12. JDK에는 자바 라이브러리의 소스 코드가 담긴 src.zip 파일이 포함되어 있다. 이 파일의 압출을 해제한 후 평소에 사용하는 텍스트 검색 도구로 레이블이 붙은 break와 continue의 사용 예를 찾아라. 그중 하나를 선별해서 레이블을 붙이지 않은 문장으로 재작성하라. [p59]

* java.lang.String.toUpperCase(Locale locale)

```java
public String toUpperCase(Locale locale) {
	if (locale == null) {
		throw new NullPointerException();
	}

	int firstLower;
	final int len = value.length;

	/* Now check if there are any characters that need to be changed. */
	scan: {
		for (firstLower = 0; firstLower < len;) {
			int c = (int) value[firstLower];
			int srcCount;
			if ((c >= Character.MIN_HIGH_SURROGATE) && (c <= Character.MAX_HIGH_SURROGATE)) {
				c = codePointAt(firstLower);
				srcCount = Character.charCount(c);
			} else {
				srcCount = 1;
			}
			int upperCaseChar = Character.toUpperCaseEx(c);
			if ((upperCaseChar == Character.ERROR) || (c != upperCaseChar)) {
				break scan;
			}
			firstLower += srcCount;
		}
		return this;
	}

	// ..
}
```

```java
public String toUpperCase(Locale locale) {
	if (locale == null) {
		throw new NullPointerException();
	}

	int firstLower;
	final int len = value.length;
	boolean needChange = false;

	/* Now check if there are any characters that need to be changed. */
	for (firstLower = 0; firstLower < len;) {
		int c = (int) value[firstLower];
		int srcCount;
		if ((c >= Character.MIN_HIGH_SURROGATE) && (c <= Character.MAX_HIGH_SURROGATE)) {
			c = codePointAt(firstLower);
			srcCount = Character.charCount(c);
		} else {
			srcCount = 1;
		}
		int upperCaseChar = Character.toUpperCaseEx(c);
		if ((upperCaseChar == Character.ERROR) || (c != upperCaseChar)) {
			needChange = true;
			break;
		}

		firstLower += srcCount;
	}

	if (!needChange) {
		return this;
	}

	// ...
}
```

#### 13. 1~49 사이의 서로 다른 숫자 여섯 개를 골라서 복권의 숫자 조합을 출력하는 프로그램을 작성하라. 서로 다른 숫자 여섯 개를 고르기 위해 먼저 1부터 49로 채워진 배열 리스트를 만든다. 임의의 인덱스(색인)을 골라서 해당하는 요소를 제거한다. 이 작업을 여섯 번 반복한다. 그런 다음 결과를 정렬해서 출력한다. [p64]

```java
// 상자에 1부터 49까지 숫자를 채운다.
List<Integer> box = new ArrayList<Integer>(49);
for (int n = 1; n <= 49; n++) {
	box.add(n);
}
// 숫자를 뽑아 넣을 바구니
List<Integer> basket = new ArrayList<Integer>(6);

Random random = new Random();
for (int i = 0; i < 6; i++) { // 6번 수행
	// 랜덤 위치
	int index = random.nextInt(box.size());
	// 상자에서 꺼냄
	int n = box.remove(index);
	// 바구니에 담음
	basket.add(n);
}
// 오름차순 정렬
Collections.sort(basket);
// 출력
System.out.println("basket = " + basket);
```

#### 14. 2차원 정수 배열을 읽고 매직 스퀘어인지 판별하는 프로그램을 작성하라. [p70]

```java
/*
 * 입력
 */
List<String> inputs = new ArrayList<>();
try (Scanner in = new Scanner(System.in);) {
	System.out.println("Input:");
	String line = null;
	while (true) {
		line = in.nextLine(); // 입력
		if ("".equals(line)) { // 아무것도 입력하지 않으면 끝
			break;
		}
		inputs.add(line);
	}
}

/*
 * 입력 검증 및 2차원 배열로 변환
 */
int size = inputs.size(); // 행의 크기(열의 크기)
// 만들어질 2차원 배열
int[][] square = new int[size][size];
for (int rowIdx = 0; rowIdx < inputs.size(); rowIdx++) {
	String line = inputs.get(rowIdx);

	String[] column = line.split("\\s+");
	if (column.length != size) {
		// 행의 크기와 열의 크기가 다르면 에러
		System.err.println("잘못된 입력입니다.");
		System.exit(0);
	}

	for (int colIdx = 0; colIdx < column.length; colIdx++) {
		square[rowIdx][colIdx] = Integer.parseInt(column[colIdx]);
	}
}

/*
 * 행, 열, 대각선의 합 검증
 */
List<Integer> sums = new ArrayList<>();
// 행
for (int rowIndex = 0; rowIndex < size; rowIndex++) {
	int sum = 0;
	for (int n : square[rowIndex]) {
		sum += n;
	}
	sums.add(sum);

	System.out.printf("행[%d] = %d\n", rowIndex, sum);
}
// 열
for (int columnIndex = 0; columnIndex < size; columnIndex++) {
	int sum = 0;
	for (int rowIndex = 0; rowIndex < size; rowIndex++) {
		sum += square[rowIndex][columnIndex];
	}
	sums.add(sum);

	System.out.printf("열[%d] = %d\n", columnIndex, sum);
}
// 대각 1
{
	int sum = 0;
	for (int i = 0; i < size; i++) {
		sum += square[i][i];
	}
	sums.add(sum);

	System.out.printf("대각1 = %d\n", sum);
}
// 대각 2
{
	int sum = 0;
	for (int i = size - 1; i >= 0; i--) {
		sum += square[i][i];
	}
	sums.add(sum);

	System.out.printf("대각2 = %d\n", sum);
}

int sum = sums.get(0);
for (int i = 1; i < sums.size(); i++) {
	if (sum != sums.get(i)) {
		System.err.println("매직 스퀘어가 아닙니다.");
		System.exit(0);
	}
}

System.out.println("매직 스퀘어!!!");
```

#### 15. 지정한 숫자 n의 파스칼 삼각형을 ArrayList<ArrayList<Integer>>에 저장하는 프로그램을 작성하라. [p71]

```java
// 횟수 (로우 수)
int loop = 10;
// 2차원 배열 리스트
List<List<Integer>> triangle = new ArrayList<>();

for (int i = 0; i < loop; i++) {
	List<Integer> row = new ArrayList<>();

	for (int j = 0; j <= i; j++) {
		// 기본값 1
		int n = 1;
		// 배열의 처음과 마지막이 아니면 계산
		if (j != 0 && j != i) {
			List<Integer> beforeRow = triangle.get(i - 1);
			n = beforeRow.get(j - 1) + beforeRow.get(j);
		}

		row.add(n);
	} // loop column

	triangle.add(row);
} // loop row

// 출력
for (List<Integer> row : triangle) {
	System.out.println(row);
}
```

#### 16. average 메서드를 개선해서 파라미터를 적어도 한 개 이상 전달받으며 호출되게 하라. [p74]

```java
public int average(int number, int... numbers) {
	int sum = number;
	int count = numbers.length + 1;

	for (int n : numbers) {
		sum += n;
	}

	return sum / count;
}
```