package solutions;

import java.util.Stack;

public class basic_calculator_ii {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        
        s = s.replaceAll(" ", "");
        
        Stack<Integer> t = new Stack<>();
        
        char operator = '+';
        int curr = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(Character.isDigit(c)) {
        		curr = curr * 10 + c -'0';
        	}
        		
        	if(i == s.length() - 1 || !Character.isDigit(c)) {
        		
        		if(operator == '+') {
        			t.push(curr);
        		} else if(operator == '-') {
        			t.push(-curr);
        		} else if(operator == '*') {
        			t.push(t.pop() * curr);
        		} else {
        			t.push(t.pop() / curr);
        		}
        		
        		
        		operator = c;
        		t.clear();
        	}
        		
        }
        
        int ret = 0;
        
        for(Integer c: t) {
        	ret += c;
        }
        
        return ret;
    }
}
