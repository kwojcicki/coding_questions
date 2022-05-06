package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class remove_all_adjacent_duplicates_in_string_ii {
	
	class Pair {
		char c;
		int count;
		
		public Pair(char c, int count) {
			this.c = c; this.count = count;
		}
	}
	
    public String removeDuplicates(String s, int k) {
    	Deque<Pair> st = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(!st.isEmpty() && st.peekLast().c == s.charAt(i) && st.peekLast().count + 1 == k) {
        		st.removeLast();
        	} else {
        		if(!st.isEmpty() && st.peekLast().c == s.charAt(i)) {
        			st.peekLast().count += 1;
        		} else {
        			st.addLast(new Pair(s.charAt(i), 1));
        		}
        	}
        }
        
        StringBuilder ret = new StringBuilder(st.size());
        
        for(Pair c : st) {
        	ret.append(String.valueOf(c.c).repeat(c.count));
        }
        
        return ret.toString();
    }
}
