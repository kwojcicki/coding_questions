package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_and_replace_pattern {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> ret = new ArrayList<>();
		char[] p = pattern.toCharArray();

		for(String word: words) {
			if(matches(word, p)) {
				ret.add(word);
			}
		}

		return ret;
	}

	public boolean matches(String word, char[] pattern) {
		char[] map = new char[26];
		boolean[] used = new boolean[26];
		Arrays.fill(map, '0');

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(map[pattern[i]- 'a'] == '0') {
				map[pattern[i] - 'a'] = c;
				if(used[c - 'a']) return false;
				used[c - 'a'] = true;
			} else if(map[pattern[i] - 'a'] != c) {
				return false;
			}
		}

		return true;
	}
}
