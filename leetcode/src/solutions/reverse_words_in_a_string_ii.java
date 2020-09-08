package solutions;

public class reverse_words_in_a_string_ii {
	public void reverseWords(char[] s) {
		if(s == null || s.length == 0) return;
		reverse(s, 0, s.length - 1);

		int start = 0;
		for(int i = 0; i < s.length; i++) {
			if(s[i] == ' ') {
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}

		reverse(s, start, s.length - 1);
	}

	public void reverse(char[] s, int start, int end) {
		for(int i = start; i <= start + (end - start) / 2; i++) {
			char temp = s[i];
			s[i] = s[end - (i - start)];
			s[end - (i - start)] = temp;
		}
	}
}
