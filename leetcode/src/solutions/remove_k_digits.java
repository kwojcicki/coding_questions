package solutions;

import java.util.Stack;

public class remove_k_digits {
	public String removeKdigits(String num, int k) {
		if(k >= num.length()) {
			return "0";
		}

		Stack<Character> s = new Stack<>();

		for(char c: num.toCharArray()) {
			if(s.isEmpty() || s.peek() < c || k == 0) {
				s.push(c);
			} else {
				while(!s.isEmpty() && s.peek() > c && k > 0) {
					s.pop();
					k--;
				}
				s.push(c);
			}
		}
		// System.out.println(s.size() + " " + num.length() + " " + k);
		while(k > 0) {
			// System.out.println("pop");
			k--;
			s.pop();
		}

		StringBuilder ret = new StringBuilder(s.size());

		while(!s.isEmpty()) {
			ret.append(s.pop());
		}
		while(!ret.isEmpty() && ret.charAt(ret.length() - 1) == '0') {
			ret.setLength(ret.length() - 1);
		}

		return ret.isEmpty() ? "0" : ret.reverse().toString();
	}
}
