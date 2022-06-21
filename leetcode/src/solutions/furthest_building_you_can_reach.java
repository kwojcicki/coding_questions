package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class furthest_building_you_can_reach {

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int ret = -1;

		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

		for(int i = 0; i < heights.length; i++){
			int height = heights[i];
			int prev = i == 0 ? heights[0] : heights[i - 1];

			// System.out.println(bricks + " " + ladders);

			if(height <= prev) {
				ret++;
				continue;
			}

			if(ladders == 0 && (height - prev) > bricks) {
				// System.out.println("break1");
				break;
			}

			if(height - prev <= bricks) {
				bricks -= (height - prev);
				q.add(height - prev);
				ret++;
				continue;
			}

			if(!q.isEmpty() && height - prev > q.peek() && ladders > 0) {
				ladders--;
				ret++;
				continue;
			}

			if(!q.isEmpty()){
				bricks += q.poll();
				ladders--;
				bricks -= (height - prev);
				q.add(height - prev);
				ret++;
				continue;
			} else if(ladders > 0){
				ret++;
				ladders--;
				continue;
			}

			// System.out.println("break2: " + (height - prev));
			break;
		}

		// System.out.println(bricks + "--" + ladders);
		return ret; 
	}
}
