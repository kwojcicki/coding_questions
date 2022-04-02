package solutions;

public class valid_palindrome_ii {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end) {
        	if(s.charAt(start) != s.charAt(end)) {
        		return isPalindrome(start + 1, end, s) || isPalindrome(start, end - 1, s);
        	}
        	start++;
        	end--;
        }
        
        return true;
    }
    
    public boolean isPalindrome(int start, int end, String s) {
    	while(start < end) {
    		if(s.charAt(start) != s.charAt(end)) return false;
    		start++;
    		end--;
    	}
    	
    	return true;
    }
    
	public boolean validPalindrome1(String s) {

		int start = 0, end = s.length() - 1;

		while(start < end) {

			if(s.charAt(start) != s.charAt(end)) {

				int newStart = start + 1;
				int newEnd = end;

				while(newStart < newEnd) {
					if(s.charAt(newStart) == s.charAt(newEnd)){
						newStart++;
						newEnd--;
					} else {
						break;
					}
				}

				if(newStart >= newEnd) return true;

				newStart = start;
				newEnd = end - 1;

				while(newStart < newEnd) {
					if(s.charAt(newStart) == s.charAt(newEnd)){
						newStart++;
						newEnd--;
					} else {
						break;
					}
				}

				if(newStart >= newEnd) return true;
				else return false;


			} else {
				start++;
				end--;
			}
		}

		return true;
	}
}
