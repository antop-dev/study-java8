package ch06.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table<K, V> {

	private List<Entry<K, V>> list = new ArrayList<>();

	public V get(K key) {
		int idx = findByKey(key);
		if (idx == -1) {
			return null;
		}
		return list.get(idx).getValue();
	}

	public void put(K key, V value) {
		Objects.requireNonNull(key, "key can't not null");
		Entry<K, V> e = new Entry<>(key, value);
		list.add(e);
	}

	public void remove(K key) {
		int idx = findByKey(key);
		if (idx == -1) {
			return;
		}
		list.remove(idx);
	}

	private int findByKey(K key) {
		for (int i =  list.size() -1  ; i >=0 ; i-- ) {
			Entry<K, V> e = list.get(i);
			if (e.getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}

}
