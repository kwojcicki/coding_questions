package solutions;

import java.util.Stack;

public class removing_stars_from_a_string {
	public String removeStars(String s) {
		Stack<Character> ret = new Stack<>();

		for(char c: s.toCharArray()) {
			if(c != '*') {
				ret.push(c);
			} else if(!ret.isEmpty()) {
				ret.pop();
			}
		}

		char[] c = new char[ret.size()];
		for(int i = ret.size() - 1; i >= 0; i--) {
			c[i] = ret.pop();
		}

		return new String(c);
	}
}
