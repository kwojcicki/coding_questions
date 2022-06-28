package solutions;

import java.util.HashSet;
import java.util.Set;

public class minimum_deletions_to_make_character_frequencies_unique {
    public int minDeletions(String s) {
    	Set<Integer> set = new HashSet<>();
        int ret = 0;
        int[] count = new int[26];
        
        for(char c: s.toCharArray()) {
        	count[c - 'a']++;
        }
        
        for(int value: count) {
            ret += value;
        	for(int i = value; i >= 0; i--) {
        		if(set.add(i)) {
        			ret -= i;
        			break;
        		}
        	}
        }
        
        return ret;
    }
}
