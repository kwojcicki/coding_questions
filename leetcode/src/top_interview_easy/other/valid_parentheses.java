package top_interview_easy.other;

import java.util.Stack;

public class valid_parentheses {
    public boolean isValid(String s) {
    	if(s == null || s.length() == 0) {
    		return true;
    	}
    	
    	
    	Stack<Character> t = new Stack<Character>();
    	
    	for(char c: s.toCharArray()) {
    		

			if( (c == ')' || c == '}' || c == ']') && t.isEmpty()) {
				return false;
			}
    		
    		if(c == '(' || c == '{' || c == '[') {
    			t.push(c);
    		} else if(c == ')') {
    			char a = t.pop();
    			if(a != '(') {
    				return false;
    			}
    		} else if(c == '}') {
    			char a = t.pop();
    			if(a != '{') {
    				return false;
    			}
    		} else if(c == ']') {
    			char a = t.pop();
    			if(a != '[') {
    				return false;
    			}
    		}
    	}
    	
    	System.out.println(t);
    	
    	return t.isEmpty();
    }
    
    public static void main(String[] args) {
    	System.out.println(new valid_parentheses().isValid("()[]{}"));
    }
}
