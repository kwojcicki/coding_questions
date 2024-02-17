package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class furthest_building_you_can_reach {

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int ret = 0;
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		for(; ret < heights.length - 1; ret++) {
			int diff = heights[ret + 1] - heights[ret];
			// System.out.println(ret + " " + heights[ret] + " " + bricks + " " + ladders + " " + diff);
			if(heights[ret] >= heights[ret + 1]) continue;
			if(diff <= bricks) {
				q.add(diff);
				bricks -= diff;
				continue;
			}
			if(ladders == 0) break;
			if(q.isEmpty() || q.peek() < diff){
				ladders--;
			} else if(!q.isEmpty()){
				ladders--;
				bricks += q.poll();
				ret--;
			}
		}
		return ret;
	}
}
