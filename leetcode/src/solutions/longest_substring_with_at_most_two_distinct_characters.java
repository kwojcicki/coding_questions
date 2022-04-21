package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longest_substring_with_at_most_two_distinct_characters {
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	map.put(s.charAt(i), i);
        	if(map.size() == 3) {
        		char lowest = s.charAt(i);
        		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        			if(entry.getValue() < map.get(lowest)) {
        				lowest = entry.getKey();
        			}
        		}
        		
        		Integer pos = map.remove(lowest);
        		curr = i - pos;
        	} else {
        		curr++;
        	}
        	max = Math.max(max, curr);
        }
        
        return max;
    }
	
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int start = 0;
        int end = 1;
        int max = 1;
        int curr = 1;
        Set<Character> set =  new HashSet<>();
        set.add(s.charAt(0));
        
        while(end < s.length()){
            set.add(s.charAt(end));
            if(set.size() > 2){
                
                
                set.clear();
                end--;
                set.add(s.charAt(end));
                
                curr = 1;
                start = end;
                while(start - 1 >= 0 && s.charAt(start - 1) == s.charAt(end)){
                    start--;
                    curr++;
                }
                
                end++;
                
            } else {
                end++;
                curr++;
                
                max = Math.max(max, curr);
            }
        }
        
        return max;
    }
}
