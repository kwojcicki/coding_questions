package solutions;

public class is_subsequence {
    public boolean isSubsequence(String s, String t) {
    	int sP = 0, tP = 0;
    	
    	while(sP < s.length() && tP < t.length()) {
    		if(s.charAt(sP) == t.charAt(tP)) {
    			sP++;
    		}
    		tP++;
    	}
    	
    	return sP == s.length();
    }
}
