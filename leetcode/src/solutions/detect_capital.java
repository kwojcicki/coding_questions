package solutions;

import java.util.regex.Pattern;

public class detect_capital {
	
    public boolean detectCapitalUse(String word) {

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
    
    public boolean detectCapitalUse1(String word) {
        return Pattern.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+", word);
    }
}
