package solutions;

public class longest_repeating_character_replacement {
	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int start = 0;
		int maxCount = 0;
		int maxLength = 0;

		for(int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'A']++;
			maxCount = Math.max(maxCount, count[s.charAt(i) - 'A']);
			if(i - start - maxCount + 1 > k) {
				count[s.charAt(start) - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, i - start + 1);
		}

		return maxLength;
	}
}
