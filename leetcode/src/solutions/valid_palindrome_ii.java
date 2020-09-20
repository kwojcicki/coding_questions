package solutions;

public class valid_palindrome_ii {
	public boolean validPalindrome(String s) {

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
