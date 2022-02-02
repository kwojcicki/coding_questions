package solutions;

import java.util.ArrayList;
import java.util.List;

public class find_all_anagrams_in_a_string {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ret = new ArrayList<>();

		char[] curr = new char[26];
		char[] past = new char[26];

		for(char c: p.toCharArray()) {
			past[c - 'a']++;
		}

		for(int i = 0; i < s.length() && i < p.length(); i++) {
			curr[s.charAt(i) - 'a']++;
		}

		for(int i = p.length(); i < s.length(); i++) {
			if(matches(curr, past)) {
				ret.add(i - p.length());
			}

			curr[s.charAt(i - p.length()) - 'a']--;
			curr[s.charAt(i) - 'a']++;
		}
		if(matches(curr, past)) {
			ret.add(s.length() - p.length());
		}
		return ret;
	}

	private static boolean matches(char[] c, char[] p) {
		for(int i = 0; i < c.length; i++) {
			if(c[i] != p[i]) return false;
		}
		return true;
	}
}
