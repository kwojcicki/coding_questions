package top_interview_easy.strings;

public class valid_palindrome {
    public boolean isPalindrome(String s) {
    	s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
        	if(!Character.isLetterOrDigit(s.charAt(left))) {
        		left++;
        		continue;
        	}
        	
        	if(!Character.isLetterOrDigit(s.charAt(right))) {
        		right--;
        		continue;
        	}
        	
        	if(s.charAt(left) != s.charAt(right)) {
        		return false;
        	}
        	left++;
        	right--;
        }
        
        return true;
    }
}
