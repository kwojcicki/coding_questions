package solutions;

import java.util.HashMap;
import java.util.Map;

public class determine_if_two_strings_are_close {
    public boolean closeStrings(String word1, String word2) {
    	if(word1.length() != word2.length()) return false;
        int[] c1 = new int[26], c2 = new int[26];
        for(int i = 0; i < word1.length(); i++) {
        	c1[word1.charAt(i) - 'a']++;
        	c2[word2.charAt(i) - 'a']++;
        }
    	
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i < c1.length; i++) {
            if(c2[i] == 0 && c1[i] != 0) return false;
        	counts.compute(c1[i], (k,v) -> v == null ? 1 : v + 1);
        	counts.compute(c2[i], (k,v) -> v == null ? -1 : v - 1);
        }
        
        for(Map.Entry<Integer, Integer> c: counts.entrySet()) {
        	if(c.getValue() != 0) return false;
        }
    	
    	return true;
    }
}
