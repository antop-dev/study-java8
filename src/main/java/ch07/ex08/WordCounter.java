package ch07.ex08;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordCounter {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = Files.newBufferedReader(Paths.get("docs/ch07/cnn.txt"));
		Map<String, Set<Integer>> map = new TreeMap<>();

		String line = null;
		for (int lineCount = 1 ; (line = reader.readLine()) != null ; lineCount++) {
			String[] split = line.split("\\s+");
			for (String word : split) {
				Set<Integer> set = map.get(word);
				if (set == null) {
					set = new TreeSet<>();
					map.put(word, set);
				}

				set.add(lineCount);
			}
		}

		System.out.println("-- result --");
		for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
