package solutions;

public class repeated_substring_pattern {
    public static boolean repeatedSubstringPattern(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
        	int length = i + 1;
        	String prefix = s.substring(0, i + 1);
        	String test = "";
        	if(s.length() % length == 0) {
        		while(test.length() != s.length()) test += prefix;
        		System.out.println(test + " " + s + " " + prefix);
        		if(test.equals(s)) return true;
        	}
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	repeatedSubstringPattern("aba");
    }
}
