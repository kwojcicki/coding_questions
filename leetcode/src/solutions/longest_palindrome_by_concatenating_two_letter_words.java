package solutions;

public class longest_palindrome_by_concatenating_two_letter_words {
    public int longestPalindrome(String[] words) {
    	int pairs = 0;
        int[] seen = new int[26 * 26];
        
        for(String w: words) {
        	if(seen[(w.charAt(1) - 'a') * 26 + w.charAt(0) - 'a'] > 0) {
        		pairs++;
        		seen[(w.charAt(1) - 'a') * 26 + w.charAt(0) - 'a']--;
        	} else {
        		seen[(w.charAt(0) - 'a') * 26 + w.charAt(1) - 'a']++;
        	}
        }
        
        for(int i = 0; i < seen.length; i++) {
        	if(i / 26 == i % 26 && seen[i] > 0) return pairs * 4 + 2;
        }
        
        return pairs * 4;
    }
}
