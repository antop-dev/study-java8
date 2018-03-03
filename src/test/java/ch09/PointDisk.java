package ch09;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PointDisk {

	public static void save(Path path, Point[] points) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));) {
			for (Point point : points) {
				oos.writeObject(point);
			}
		}
	}

	public static Point[] load(Path path) throws IOException, ClassNotFoundException {
		List<Point> list = new ArrayList<>();
		int count = 0;

		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));) {
			try {
				for (; ; ) {
					list.add((Point) ois.readObject());
					count++;
				}
			} catch (EOFException eof) {
				// end
			}
		}

		return list.toArray(new Point[count]);
	}

}
