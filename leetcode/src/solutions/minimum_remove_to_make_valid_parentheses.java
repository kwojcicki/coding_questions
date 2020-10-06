package solutions;

import java.util.Stack;

public class minimum_remove_to_make_valid_parentheses {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> st = new Stack<>();
		String[] a = s.split("");
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].equals("(")) {
				st.add(i);
			} else if(a[i].equals(")")) {
				if(!st.isEmpty()) {
					st.pop();
				} else {
					a[i] = "";
				}
			}
		}
		
		while(!st.isEmpty()) a[st.pop()] = "";
		
		return String.join("", a);
	}
	
	public String minRemoveToMakeValid1(String s) {
		StringBuilder ret = new StringBuilder();

		int open = 0, closed = 0;
		for(char c: s.toCharArray()) {
			if(c == ')') {
				if(open >= 1) { ret.append(c); open--; }
			} else if(c == '(') {
				open++;
				ret.append(c);
			} else {
				ret.append(c);
			}
		}

		s = ret.toString();
		// System.out.println(s);
		ret.setLength(0);

		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if(c == '(') {
				if(closed >= 1) { ret.append(c); closed--; }
			} else if(c == ')') {
				closed++;
				ret.append(c);
			} else {
				ret.append(c);
			}
		}

		return ret.reverse().toString();   
	}
}
