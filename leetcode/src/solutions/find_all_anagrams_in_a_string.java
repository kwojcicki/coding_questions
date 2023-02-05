package solutions;

import java.util.ArrayList;
import java.util.List;

public class find_all_anagrams_in_a_string {
	public List<Integer> findAnagrams(String s2, String s1) {
		List<Integer> ret = new ArrayList<>();

        char[] c = new char[26];
        for(char c1: s1.toCharArray()) c[c1 - 'a']++;
        int req = s1.length();

        int start = 0;
        for(int end = 0; end < s2.length(); end++){
            while(c[s2.charAt(end) - 'a'] <= 0 && start < end){
                req++;
                c[s2.charAt(start++) - 'a']++;
            }

            if(c[s2.charAt(end) - 'a'] > 0){
                c[s2.charAt(end) - 'a']--;
                req--;
                if(req == 0) ret.add(start);
            } else {
                start = end + 1;
            }
        }

        return ret;
	}
	
	public List<Integer> findAnagrams1(String s, String p) {
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
