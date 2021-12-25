package solutions;

import java.util.Stack;

public class basic_calculator_ii {
    public int calculate1(String s) {
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
    

    public int calculateDiscussion(String s) {
    	if(s == null || s.length() == 0) return 0;
    	s = s.trim();
    	char oper = '+';
    	int number = 0;
    	char[] c = s.toCharArray();
    	Stack<Integer> n = new Stack<>();
    	
    	for(int i = 0; i < c.length; i++) {

    		if(Character.isDigit(c[i])) {
    			number = number * 10 + (c[i] - '0');
    		}
            
            if(c[i] == ' ' || (Character.isDigit(c[i]) && i != c.length - 1)) {
    			continue;
    		}
    		
    		if(oper == '+') {
    			n.push(number);
    		} else if(oper == '-') {
    			n.push(- number);
    		} else if(oper == '*') {
    			n.push(n.pop() * number);
    		} else if(oper == '/') {
    			n.push(n.pop() / number);
    		}
    		oper = c[i];
    		number = 0;
    	}
    	
    	return n.stream().reduce((i, j) -> i + j).orElse(0);
    }
    
    public int calculate(String s) {
    	int ret = 0;
    	
    	if(s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	Stack<Integer> nums = new Stack<>();
    	Stack<Character> opers = new Stack<>();
    	
    	char[] c = s.toCharArray();
    	int i = 0;
    	
    	while(i < c.length) {
    		if(c[i] == ' ') {
    			i++;
    			continue;
    		} else if(Character.isDigit(c[i])) {
    			int number = 0;
    			while(i < c.length && Character.isDigit(c[i]) ) {
    				number = number * 10 + (c[i] - '0');
        			i++;
    			}
    			nums.push(number);
    			
    			if(!opers.isEmpty() && opers.peek() == '*') {
    				opers.pop();
    				int num1 = nums.pop();
    				int num2 = nums.pop();
    				nums.push(num1 * num2);
    			} else if(!opers.isEmpty() && opers.peek() == '/') {
    				opers.pop();
    				int num1 = nums.pop();
    				int num2 = nums.pop();
    				nums.push(num2 / num1);
    			}
    		} else {
    			opers.push(c[i]);
    			i++;
    		}
    	}
    	
    	if( nums.size() == 1) return nums.peek();
    	
    	
    	while(!nums.isEmpty()) {
    		int num1 = nums.pop();
    		char oper = opers.isEmpty() ? '+' : opers.pop();
    		
    		if(oper == '+') {
    			ret += num1;
    		} else if(oper == '-') {
    			ret -= num1;
    		}
    	}
    	
    	return ret;
    }
}
