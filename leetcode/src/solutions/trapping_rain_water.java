package solutions;

import java.util.Stack;

public class trapping_rain_water {
    public int trap(int[] height) {
        int ret = 0;
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while(i < height.length) {
        	if(s.isEmpty() || height[i] <= height[s.peek()]) {
        		s.add(i);
        		i++;
        	} else {
        		int bottom = s.pop();
        		ret += s.empty() ? 0 : (Math.min(height[s.peek()], height[i]) - 
        				height[bottom]) * (i - s.peek() - 1);
        	}
        }
        
        return ret;
    }
}
