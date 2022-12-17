package solutions;

import java.util.Stack;

public class evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for(String token: tokens) {
    		if(token.equals("*")) {
    			int n2 = stack.pop();
    			int n1 = stack.pop();
    			stack.push(n1 * n2);
    		} else if(token.equals("/")) {
    			int n2 = stack.pop();
    			int n1 = stack.pop();
    			stack.push(n1 / n2);
    		} else if(token.equals("+")) {
    			int n2 = stack.pop();
    			int n1 = stack.pop();
    			stack.push(n1 + n2);
    		} else if(token.equals("-")) {
    			int n2 = stack.pop();
    			int n1 = stack.pop();
    			stack.push(n1 - n2);
    		} else {
    			stack.push(Integer.parseInt(token));
    		}
    	}
		
		return stack.pop();
    }
}
