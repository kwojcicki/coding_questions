package solutions;

public class longest_palindromic_substring {

    public String longestPalindrome(String s) {
        String ret = "";
        
        for(int i = 0; i < s.length() * 2 - 1; i++) {
        	int left = i / 2;
        	int right = i / 2 + i % 2;
        	while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        		left--;
        		right++;
        	}
        	
        	if(right - left - 1 > ret.length()) {
    			ret = s.substring(left + 1, right);
    		}
        }
        
        return ret;
    }
}
