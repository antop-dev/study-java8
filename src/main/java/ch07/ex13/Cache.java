package ch07.ex13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K, V> extends LinkedHashMap<K, V> {

	private int limit;

	public Cache(int limit) {
		this.limit = limit;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() == limit + 1;
	}

	public static void main(String[] args) {
		Cache<String, Integer> cache = new Cache<>(5);
		cache.put("key1", 1);
		cache.put("key2", 1);
		cache.put("key3", 1);
		cache.put("key4", 1);
		cache.put("key5", 1);
		cache.put("key6", 1);
		cache.put("key7", 1);
		cache.put("key8", 1);
		cache.put("key9", 1);
		cache.put("key10", 1);

		for (Map.Entry<String, Integer> entry : cache.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

	}
}
