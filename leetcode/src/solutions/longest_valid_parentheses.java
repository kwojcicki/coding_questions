package solutions;

import java.util.Stack;

public class longest_valid_parentheses {
	public int longestValidParentheses(String s) {
		char[] c = s.toCharArray();
		int[] dp = new int[s.length()];
		int ret = 0;
		int left = 0;

		for(int i = 0; i < c.length; i++) {
			if(c[i] == '(') {
				left++;
			} else if(left > 0){
				dp[i] = dp[i - 1] + 2;
				dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
				left--;
				ret = Math.max(ret, dp[i]);
			}
		}

		return ret;
	}

	public int longestValidParentheses1(String s) {
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		char[] c = s.toCharArray();
		int ret = 0;


		for(int i = 0; i < s.length(); i++) {
			if(c[i] == '(') {
				st.push(i);
			} else {
				st.pop();
				if(st.isEmpty()) {
					st.push(i);
				}

				ret = Math.max(ret, i - st.peek());
			}
		}

		return ret;
	}

	// TLE
	public int longestValidParentheses2(String s) {
		Stack<Character> st = new Stack<>();
		char[] c = s.toCharArray();
		int ret = 0;

		for(int i = 0; i < c.length; i++) {
			int curr = 0;
			st.clear();
			for(int j = i; j < c.length; j++) {
				if(c[j] == ')' && st.isEmpty()) {
					break;
				} else if(c[j] == '(') {
					st.add('(');
					curr++;
				} else {
					curr++;
					st.pop();
					if(st.isEmpty()){
						ret = Math.max(ret, curr);
					}
				}
			}
		}

		return ret;
	}
}
