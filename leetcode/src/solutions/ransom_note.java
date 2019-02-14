package solutions;

public class ransom_note {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for(char c: ransomNote.toCharArray()) {
        	chars[c - 'a']++;
        }
        
        for(char c: magazine.toCharArray()) {
        	chars[c - 'a']--;
        }
        
        for(int a: chars) {
        	if(a > 0) {
        		return false;
        	}
        }
        
        return true;
    }
}
