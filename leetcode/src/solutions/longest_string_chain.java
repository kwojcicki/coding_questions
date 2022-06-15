package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longest_string_chain {

	public int longestStrChain(String[] words) {
		int max = 1;

		Map<String, Integer> map = new HashMap<>();

		Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));

		for(String word: words) map.put(word, 1);

		for(String word: words) {
			int curr = map.get(word);
			for(int i = 0; i < word.length(); i++) {
				String w = word.substring(0, i) + word.substring(i + 1, word.length());
				if(map.containsKey(w)) {
					map.put(w, Math.max(map.get(w), curr + 1));
					max = Math.max(map.get(w), max);
				}
			}
		}

		return max;
	}
}
