package solutions;

import java.util.Stack;

public class largest_rectangle_in_histogram {
	public int largestRectangleArea(int[] heights) {
		int ret = 0, i = 0;
		Stack<Integer> s = new Stack<>();
		
		while(i < heights.length) {
			if(s.isEmpty() || heights[i] >= heights[s.peek()]) {
				s.push(i);
				i++;
			} else {
				int prevIndex = s.pop();
				ret = Math.max(ret, heights[prevIndex] * (s.isEmpty() ? i : i - s.peek() - 1));
			}
		}
		
		while(!s.isEmpty()) {
			int prevIndex = s.pop();
			ret = Math.max(ret, heights[prevIndex] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		
		return ret;
	}
}
