package solutions;

public class first_unique_character_in_a_string {
	public int firstUniqChar(String s) {
		int[] seen = new int[26];
		for(char c: s.toCharArray()) seen[c - 'a']++;
		for(int i = 0; i < s.length(); i++) if(seen[s.charAt(i) - 'a'] == 1) return i;
		return -1; 
	}
}
