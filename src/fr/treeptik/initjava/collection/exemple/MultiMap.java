package fr.treeptik.initjava.collection.exemple;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MultiMap extends AbstractMap<String, String> {

	private HashMap<String, List<String>> map = new HashMap<>();

	@Override
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return null;
	}

	@Override
	public String put(String key, String value) {
		if (map.containsKey(key)) {
			Boolean present = false;
			for (String string : map.get(key)) {
				if (string.equalsIgnoreCase(value)) {
					present = true;
				}
			}
			if (!present) {
				map.get(key).add(value);
			}
		} else {
			ArrayList<String> values = new ArrayList<>();
			values.add(value);
			map.put(key, values);
		}

		return null;
	}

	@Override
	public int size() {
		
		return map.size();
	}

	@Override
	public Set<String> keySet() {

		return map.keySet();
	}

	public List<String> getValue(Object key) {

		return map.get(key);
	}

}
