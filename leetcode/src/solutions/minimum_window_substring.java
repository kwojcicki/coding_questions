package solutions;

import java.util.HashSet;
import java.util.Set;

public class minimum_window_substring {
	public String minWindow(String s, String t) {
		String ret = "";
		int[] count = new int[126];
		int req = t.length();
		for(char c: t.toCharArray()) {
			count[c - 'A']++;
		}
		
		int start = 0, end = 0;
		while(end < s.length()) {
			if(count[s.charAt(end++) - 'A']-- > 0) req--;
			while(req == 0) {
				if(ret.length() == 0 || ret.length() > end - start)  ret = s.substring(start, end);
				if(count[s.charAt(start++) - 'A']++ == 0) req++;
			}
		}
		
		return ret;
	}
	
	public String minWindow1(String s, String t) {
		int[] seen = new int[122 - 65 + 1];
		int[] required = new int[122 - 65 + 1];
		Set<Character> r = new HashSet<>();

		for(char c: t.toCharArray()) { 
			required[c - 'A']++;
			r.add(c);
		}

		String ret = "";

		int start = 0, end = 0;

		for(char c: s.toCharArray()) {
			seen[c - 'A']++;
			end++;
			if(matches(seen, required)) {
				ret = s.substring(start, end);
				break;
			}
		}

		while(true) {
			// System.out.println(start + " " + end + " " + matches(seen, required));
			if(matches(seen, required)) {
				if(end - start < ret.length()) ret = s.substring(start, end);
				seen[s.charAt(start) - 'A']--;
				start++;
				while(start < end && !r.contains(s.charAt(start))) {
					seen[s.charAt(start) - 'A']--;
					start++;
				}
			} else if(end >= s.length()) {
				break;
			} else {
				seen[s.charAt(end) - 'A']++;
				end++;
			}
		}

		return ret;
	}

	public boolean matches(int[] seen, int[] required) {
		for(int i = 0; i < required.length; i++) {
			if(seen[i] < required[i]) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new minimum_window_substring().minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(new minimum_window_substring().minWindow("a", "a"));
		System.out.println(new minimum_window_substring().minWindow("a", "aa"));
		System.out.println(new minimum_window_substring().minWindow("cabwefgewcwaefgcf", "cae"));
	}

	// ADOBECODEBANC
	// 0123456789123
}
