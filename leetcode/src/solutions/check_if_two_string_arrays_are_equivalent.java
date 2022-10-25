package solutions;

public class check_if_two_string_arrays_are_equivalent {
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		int w1 = 0;
		int i1 = 0;

		int w2 = 0;
		int i2 = 0;

		while(w1 < word1.length && w2 < word2.length) {
			if(word1[w1].charAt(i1) != word2[w2].charAt(i2)) return false;
			i1++;
			i2++;

			if(i1 >= word1[w1].length()) {
				i1 = 0;
				w1++;
			}

			if(i2 >= word2[w2].length()) {
				i2 = 0;
				w2++;
			}
		}

		return w1 == word1.length && i1 == 0 && 
				w2 == word2.length && i2 == 0;
	}
}
