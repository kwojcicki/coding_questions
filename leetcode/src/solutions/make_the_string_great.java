package solutions;

import java.util.Stack;

public class make_the_string_great {
    public String makeGood(String s) {
Stack<Character> st = new Stack<>();
        
        for(char c: s.toCharArray()) {
        	if(st.isEmpty()) {
        		st.add(c);
        	} else {
        		char a = st.peek();
        		if(c - 'a' == a - 'A' || a - 'a' == c - 'A') {
        			st.pop();
        		} else {
        			st.add(c);
        		}
        	}
        }
        
        char[] ret = new char[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()) {
        	ret[i--] = st.pop();
        }
        
        return new String(ret);
    }
}
