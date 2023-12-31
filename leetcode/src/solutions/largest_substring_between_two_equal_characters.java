package solutions;

import java.util.Arrays;

public class largest_substring_between_two_equal_characters {
    public int maxLengthBetweenEqualCharacters(String s) {
    	int ret = -1;
        int[] left = new int[26];
        Arrays.fill(left, -1);
        for(int i = 0; i < s.length(); i++) {
        	int c = s.charAt(i) - 'a';
        	if(left[c] == -1) {
        		left[c] = i;
        	}
        	
        	ret = Math.max(ret, i - left[c] - 1);
        }
        
        return ret;
    }
}
