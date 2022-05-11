package solutions;

public class count_sorted_vowel_strings {

	public int countVowelStrings(int n) {
		int[] count = new int[] { 1, 1, 1, 1, 1};
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < 5; j++) {
				count[j] += count[j - 1];
			}
		}

		int ret = 0;
		for(int i: count) ret += i;

		return ret;
	}

	private int count = 0;
	public int countVowelStrings1(int n) {
		recurse(0, n);

		return count;
	}

	public void recurse(int charsIndex, int n) {
		if(n == 0) {
			count++;
			return;
		}

		for(int i = charsIndex; i < 5; i++) {
			recurse(i, n - 1);
		}
	}
}
