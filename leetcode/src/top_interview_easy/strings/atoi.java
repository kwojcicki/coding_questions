package top_interview_easy.strings;

public class atoi {
    public int myAtoi(String str) {
    	
    	if(str.equals("")) {
    		return 0;
    	}
    	
    	String temp = "";
    	int i = 0;
    	for(; i < str.length(); i++) {
    		if(str.charAt(i) != ' ') {
    			break;
    		}
    	}
    	
    	if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
    		temp += str.charAt(i);
    		i++;
    	}
    	
    	for(;i < str.length(); i++) {
    		if(Character.isDigit(str.charAt(i))) {
    			temp += str.charAt(i);
    		} else {
    			break;
    		}
    	}
    	
    	if(temp.equals("") || temp.equals("-") || temp.equals("+")) {
    		temp = "0";
    	}
    	
    	if(Double.parseDouble(temp) > Integer.MAX_VALUE) {
    		return Integer.MAX_VALUE;
    	} else if(Double.parseDouble(temp) < Integer.MIN_VALUE) {
    		return Integer.MIN_VALUE;
    	}
    	
        return Integer.parseInt(temp);
    }
}
