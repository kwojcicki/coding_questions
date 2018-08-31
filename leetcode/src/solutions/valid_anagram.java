package solutions;

public class valid_anagram {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        for(char c: s.toCharArray()) {
        	a[c - 'a']++;
        }
        
        for(char c: t.toCharArray()) {
        	a[c - 'a']--;
        }
        
        
        for(int c: a) {
        	if(c != 0) {
        		return false;
        	}
        }
        
        return true;
    }
}
