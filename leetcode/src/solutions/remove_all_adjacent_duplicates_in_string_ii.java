package solutions;

import java.util.Stack;

public class remove_all_adjacent_duplicates_in_string_ii {
	
	class Pair {
		char c;
		int count;
		
		public Pair(char c, int count) {
			this.c = c; this.count = count;
		}
	}
	
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(!st.isEmpty() && st.peek().c == s.charAt(i) && st.peek().count + 1 == k) {
        		for(int j = 0;j < k - 1; j++) st.pop();
        	} else {
        		if(!st.isEmpty() && st.peek().c == s.charAt(i)) {
        			st.push(new Pair(s.charAt(i), st.peek().count + 1));
        		} else {
        			st.push(new Pair(s.charAt(i), 1));
        		}
        	}
        }
        
        StringBuilder ret = new StringBuilder(st.size());
        
        while(!st.isEmpty()) {
        	ret.append(st.pop().c);
        }
        
        return ret.reverse().toString();
    }
}
