package solutions;

import java.util.HashMap;
import java.util.Map;

public class longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        char[] count = new char[128];
        int left = 0;
        int ret = 0;
        
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
            
            while(count[s.charAt(i)] > 1){
                count[s.charAt(left)]--;
                left++;
            }
            
            ret = Math.max(i - left + 1, ret);
        }
        
        return ret;
    }
    
    public int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] c = s.toCharArray();
		int max = 0;
		int start = 0;

		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(c[i])) {
				max = Math.max(i - start, max);
				start = map.get(c[i]) + 1;
				i = start - 1;
				map.clear();
				
			} else {
				map.put(c[i], i);
				max = Math.max(i - start + 1, max);
			}
		}

		return max;
    }
}
