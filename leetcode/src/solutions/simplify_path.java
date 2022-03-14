package solutions;

import java.util.Stack;

public class simplify_path {
	public String simplifyPath(String path) {
		Stack<String> st = new Stack<>();

		for(String s: path.split("/")) {
			if(s.isBlank() || s.equals(".")) {
				continue;
			}
			if(s.equals("..")) {
				if(!st.isEmpty()) {
					st.pop();
				}
			} else {
				st.push(s);
			}
		}

		StringBuilder ret = new StringBuilder();

		for(String s: st) {
			ret.append("/");
			ret.append(s);
		}

		return ret.length() == 0 ? "/" : ret.toString();
	}
}
