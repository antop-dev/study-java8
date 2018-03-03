package ch06.ex14;

import java.util.ArrayList;

public class Closeables {
	public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
		Exception ex = null;
		for (T elem : elems) {
			try {
				elem.close();
			} catch (Exception e) {
				if (ex == null) {
					ex = e;
				} else {
					ex.addSuppressed(e);
				}
			}
		}
	}
}
