package solutions;

public class buddy_strings {
	public boolean buddyStrings(String A, String B) {
		if(A == null && B == null) return true;
		else if(A == null || B == null) return false;

		if(A.length() != B.length()) return false;

		int otherChange = -1;
		boolean madeChange = false;
		char[] count = new char[26];

		for(int i = 0; i < A.length(); i++) {
			count[A.charAt(i) - 'a']++;
			if(A.charAt(i) == B.charAt(i)) continue;

			if(otherChange == -1) {
				otherChange = i;
			} else if(!madeChange) {
				madeChange = true;
				if(!(A.charAt(otherChange) == B.charAt(i) && A.charAt(i) == B.charAt(otherChange))) {
					return false;
				}
			} else {
				return false;
			}

		}

		if(!madeChange && otherChange == -1) {
			for(int i = 0; i < count.length; i++) {
				if(count[i] > 1) return true;
			}
		}


		return madeChange; 
	}
}
