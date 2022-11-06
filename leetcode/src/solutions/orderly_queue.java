package solutions;

import java.util.Arrays;

public class orderly_queue {
	public String orderlyQueue(String s, int k) {
		if(k > 1){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			return new String(c);
		}

		String min = s;
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i < s.length(); i++) {
			if(min.compareTo(sb.toString()) > 0) {
				min = sb.toString();
			}

			char c = sb.charAt(0);
			sb = sb.deleteCharAt(0);
			sb = sb.append(c);
		}

		return min;
	}
}
