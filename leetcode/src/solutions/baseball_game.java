package solutions;

import java.util.Stack;

public class baseball_game {
	public int calPoints(String[] ops) {        
		Stack<Integer> s = new Stack<>();

		for(String op: ops) {
			if(op.equals("C")) {
				s.pop();
			} else if(op.equals("D")) {
				s.push(s.peek() * 2);
			} else if(op.equals("+")) {
				int x = s.pop();
				int y = s.pop();
				s.push(y); s.push(x); s.push(x + y);
			} else {
				s.push(Integer.valueOf(op));
			}
		}

		int ret = 0;
		while(!s.isEmpty()) ret += s.pop();
		return ret;
	}
}
