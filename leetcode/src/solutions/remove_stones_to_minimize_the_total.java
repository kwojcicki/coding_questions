package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class remove_stones_to_minimize_the_total {
	public int minStoneSum(int[] piles, int k) {
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i: piles) q.add(i);

		while(k-- > 0) {
			int t = q.poll();
			q.add(t - t / 2);
		}
		return q.stream().reduce((a,b) -> a + b).get();
	}
}
