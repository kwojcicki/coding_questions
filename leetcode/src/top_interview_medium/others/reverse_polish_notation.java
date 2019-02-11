package top_interview_medium.others;

import java.util.Stack;

public class reverse_polish_notation {
    public int evalRPN(String[] tokens) {
    	Stack<String> stack = new Stack<String>();
    	
    	for(String token: tokens) {
    		if(token.equals("*")) {
    			int n2 = Integer.parseInt(stack.pop());
    			int n1 = Integer.parseInt(stack.pop());
    			stack.push((n1 * n2) + "");
    		} else if(token.equals("/")) {
    			int n2 = Integer.parseInt(stack.pop());
    			int n1 = Integer.parseInt(stack.pop());
    			stack.push((n1 / n2) + "");
    		} else if(token.equals("+")) {
    			int n2 = Integer.parseInt(stack.pop());
    			int n1 = Integer.parseInt(stack.pop());
    			stack.push((n1 + n2) + "");
    		} else if(token.equals("-")) {
    			int n2 = Integer.parseInt(stack.pop());
    			int n1 = Integer.parseInt(stack.pop());
    			stack.push((n1 - n2) + "");
    		} else {
    			stack.push(token);
    		}
    	}
		
		return Integer.parseInt(stack.pop());
    }
    
}
