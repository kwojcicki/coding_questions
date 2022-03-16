package solutions;

import java.util.Stack;

public class validate_stack_sequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	Stack<Integer> s = new Stack<>();
    	
    	int iPushed = 0;
    	int iPopped = 0;
    	
    	while(iPushed < pushed.length && iPopped < popped.length) {
    		if(!s.isEmpty() && s.peek() == popped[iPopped]) {
    			iPopped++;
    			s.pop();
    			continue;
    		}
    		
    		s.push(pushed[iPushed]);
    		iPushed++;
    	}
        //System.out.println(iPushed + "  " + iPopped);
        //System.out.println(s);
    	
    	while(iPopped < popped.length) {
    		if(!s.isEmpty() && s.peek() == popped[iPopped]) {
    			iPopped++;
    			s.pop();
    		} else {
    			break;
    		}
    	}
    	
        //System.out.println(iPushed + "  " + iPopped);
        //System.out.println(s);
    	return s.isEmpty();
    }
}
