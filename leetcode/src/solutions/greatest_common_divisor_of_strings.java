package solutions;

public class greatest_common_divisor_of_strings {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.length() > str1.length()) return gcdOfStrings(str2, str1);
        
        for(int i = str2.length(); i > 0; i--) {
        	String t = str2.substring(0, i);
        	if(check(t, str1, str2)) return t;
        }
        
        return "";
    }
    
    public boolean check(String t, String str1, String str2) {
    	if(str1.length() % t.length() != 0 || 
    			str2.length() % t.length() != 0) return false;
    	
    	for(int i = 0; i < str1.length(); i++) {
    		if(str1.charAt(i) != t.charAt(i % t.length())) return false;
    	}
    	
    	for(int i = 0; i < str2.length(); i++) {
    		if(str2.charAt(i) != t.charAt(i % t.length())) return false;
    	}
    	
    	return true;
    }
}
