package solutions;

import java.util.Stack;

public class buildings_with_an_ocean_view {
	public int[] findBuildings(int[] heights) {
		Stack<Integer[]> s = new Stack<>();

		for(int i = heights.length - 1; i >= 0; i--) {
			if(s.isEmpty() || heights[i] > s.peek()[0]) {
				s.push(new Integer[] {heights[i], i});
			}
		}

		int[] ret = new int[s.size()];
		for(int i = 0; !s.isEmpty(); i++) {
			ret[i] = s.pop()[1];
		}
		return ret;
	}
}
