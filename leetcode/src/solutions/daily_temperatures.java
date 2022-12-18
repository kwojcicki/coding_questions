package solutions;

import java.util.Stack;

public class daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = temperatures.length - 1; i >= 0; i--) {
        	while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
        		s.pop();
        	}
        	
        	r[i] = s.isEmpty() ? 0 : s.peek() - i;
        	s.push(i);
        }
        
        return r;
    }
}
