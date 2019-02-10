package top_interview_easy.strings;

import java.util.Arrays;

public class longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
    	
    	if(strs == null || strs.length == 0) {
    		return "";
    	}
    	
        String pre = "";
        
        int min = Arrays.stream(strs).mapToInt(i -> i.length()).min().getAsInt();
        
        for(int i = 0; i < min; i++) {
        	char s = '-';
        	for(String str: strs) {
        		if(s == '-') {
        			s = str.charAt(i);
        		} else if(str.charAt(i) != s) {
        			return pre;
        		}
        	}
        	pre += s;
        }
        
        return pre;
    }
}
