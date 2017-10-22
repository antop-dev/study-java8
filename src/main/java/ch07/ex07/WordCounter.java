package ch07.ex07;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch07/cnn.txt"));
		Map<String, Integer> counts = new TreeMap<>();

		String line = null;
		while((line = reader.readLine()) != null) {
			String[] split = line.split("\\s+");
			for (String word : split) {
				counts.merge(word, 1, (i1, i2) -> Integer.sum(i1, i2));
			}
		}

		System.out.println("-- result --");
		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
