package solutions;

public class basic_calculator {
	int i = 0;
    public int calculate(String s) {
    	i = 0;
    	return helper(s.toCharArray());
    }
    
    public int helper(char[] c) {
    	int ret = 0;
    	boolean add = true;
    	
        for(; i < c.length; i++) {
        	int t = 0;
        	if(c[i] == '(') {
        		i++;
        		t = helper(c);
        		if(add) {
        			ret += t;
        		} else {
        			ret -= t;
        		}
        	} else if(Character.isDigit(c[i])) {
        		while(i < c.length && Character.isDigit(c[i])) {
        			t = t * 10 + c[i] - '0';
        			i++;
        		}
        		i--;
        		if(add) {
        			ret += t;
        		} else {
        			ret -= t;
        		}
        	} else if(c[i] == ' ') continue;
        	else if(c[i] == ')') break;
        	else {
        		add = c[i] == '+';
        	}
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	basic_calculator t = new basic_calculator();
    	System.out.println(t.calculate("1 + 1"));
    	System.out.println(t.calculate(" 2-1 + 2 "));
    	System.out.println(t.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
