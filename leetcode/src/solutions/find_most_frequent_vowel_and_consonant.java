package solutions;

public class find_most_frequent_vowel_and_consonant {
    public int maxFreqSum(String s) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()) counts[c - 'a']++;
        
        int maxVowel = 0;
        int maxConsanant = 0;
        for(int i = 0; i < counts.length; i++) {
        	if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
        		maxVowel = Math.max(counts[i], maxVowel);
        	} else {
        		maxConsanant = Math.max(counts[i], maxConsanant);
        	}
        }
        
        return maxVowel + maxConsanant;
    }
}
