package solutions;

import java.util.regex.Pattern;

public class detect_capital {

    public boolean detectCapitalUse(String word) {
    	if(word.length() == 1) return true;
    	char[] c = word.toCharArray();
    	boolean f = c[0] < 'a';
    	int count = 0;
    	
    	for(char c1: c) if(c1 < 'a') count++;
    	
    	return (f && count == 1) || (!f && count == 0) || (word.length() == count);
    }
    
    public boolean detectCapitalUse1(String word) {

    	boolean allCaps = word.charAt(0) < 'a';
    	
    	char[] c = word.toCharArray();
    	
    	for(int i = 1; i < c.length; i++) {
    		if(c[i] < 'a') {
    			if(!allCaps) {
        			return false;
    			}
    		} else {
    			if(i != 1 && allCaps) return false;
    			allCaps = false;
    		}
    	}

    	return true;
    }
    
    public boolean detectCapitalUse2(String word) {
        return Pattern.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+", word);
    }
}
