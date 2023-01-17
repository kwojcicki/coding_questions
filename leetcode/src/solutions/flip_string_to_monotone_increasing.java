package solutions;

public class flip_string_to_monotone_increasing {
	public int minFlipsMonoIncr(String s) {
		int ones = s.charAt(0) == '1' ? 1 : 0;
		int[] swaps = new int[s.length()];

		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				ones++;
				swaps[i] = swaps[i - 1];
			} else {
				swaps[i] = Math.min(ones, 1 + swaps[i - 1]);
			}
		}

		return swaps[swaps.length - 1];
	}
}
