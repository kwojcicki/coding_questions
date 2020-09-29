package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class word_pattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");

		if(words.length != pattern.length()) return false;

		Map<Character, String> map = new HashMap<>();
		Set<String> matched = new HashSet<>();

		for(int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(map.containsKey(c)) {
				if(!words[i].equals(map.get(c))) {
					return false;
				}
			} else {
				if(matched.contains(words[i])) return false;
				map.put(c, words[i]);
				matched.add(words[i]);
			}
		}

		return true;
	}
}
