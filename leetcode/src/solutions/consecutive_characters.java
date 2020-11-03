package solutions;

public class consecutive_characters {
	public int maxPower(String s) {
		int max = 0;

		if(s == null || s.length() == 0) {
			return 0;
		}

		max = 1;
		int curr = 1;

		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i - 1)) {
				curr++;
				max = Math.max(max, curr);
			} else {
				max = Math.max(max, curr);
				curr = 1;
			}
		}

		return max;
	}
}
