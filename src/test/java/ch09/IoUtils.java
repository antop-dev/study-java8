package ch09;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class IoUtils {

	public static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] bytes = new byte[1024];

		int length = -1;
		while ((length = in.read(bytes)) != -1) {
			out.write(bytes, 0, length);
		}
	}

	public static void copyWithTemp(InputStream in, OutputStream out) throws IOException {
		Path temp = Files.createTempFile("corejava8-", ".tmp");
		Files.copy(in, temp, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(temp, out);
		Files.delete(temp);
	}

}
