package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class jump_game_vi {

    public int maxResult(int[] nums, int k) {
    	Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i -> -i[0]));

		for(int i = 0; i < nums.length; i++) {
            // System.out.println(i + " " + q);
			if(q.isEmpty()) {
				q.add(new int[] {nums[i], i});
			} else {
				while(q.peek()[1] < i - k) {
					q.poll();
				}
				if(i == nums.length - 1) return nums[i] + q.peek()[0];
				q.add(new int[] {nums[i] + q.peek()[0], i });
				
			}
		}

		return q.peek()[0];
    }
}
