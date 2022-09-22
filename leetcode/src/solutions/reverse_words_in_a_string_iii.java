package solutions;

public class reverse_words_in_a_string_iii {
	public String reverseWords(String s) {
		char[] c = s.toCharArray();

		int prev = 0;
		for(int i = 0; i < c.length; i++) {
			if(c[i] == ' ') {
				reverse(c, prev, i - 1);
				prev = i + 1;
			}
		}

		reverse(c, prev, c.length - 1);
		return new String(c);
	}

	public void reverse(char[] c, int start, int end) {
		while(start < end) {
			char t = c[start];
			c[start++] = c[end];
			c[end--] = t;
		}
	}
}
