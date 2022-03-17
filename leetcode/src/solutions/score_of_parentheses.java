package solutions;

import java.util.Stack;

public class score_of_parentheses {
	

	public int scoreOfParentheses(String s) {
		Stack<Integer> st = new Stack<>();
		int curr = 0;
		
		for(char c: s.toCharArray()) {
			if(c == '(') {
				st.push(curr);
				curr = 0;
			} else {
				curr = st.pop() + Math.max(2 * curr, 1);
			}
		}
		
		return curr;
	}
	
	int index = 0;
	public int scoreOfParentheses1(String s) {
		return helper(s.toCharArray());
	}

	public int helper(char[] c) {
		int s = 0;
		int openCount = 0;
		while(index < c.length) {
			if(index + 1 < c.length && c[index] == '(' && c[index + 1] == ')') {
				s += 1;
				index += 2;
			} else if(c[index] == '(') {
				index++;
				openCount++;
				s += 2 * helper(c);
			} else {
				if(openCount == 0) {
					break;
				}

				openCount--;
				index++;
				s += helper(c);
			}
		}

		return s;
	}
}
