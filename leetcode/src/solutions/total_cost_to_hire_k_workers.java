package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class total_cost_to_hire_k_workers {
	public long totalCost(int[] costs, int k, int candidates) {
		long ret = 0;

		Queue<Integer> q = new PriorityQueue<>((a,b) -> {
			if(costs[a] == costs[b]) {
				return a - b;
			}

			return costs[a] - costs[b];
		});

		for(int i = 0; i < candidates; i++) {
			q.add(i);
		}
		for(int i = costs.length - 1; i > costs.length - 1 - candidates && i >= 0 && i >= candidates; i--) {
			q.add(i);
		}

		int left = candidates;
		int right = costs.length - 1 - candidates;
		while(k-- != 0) {
			int n = q.poll();
			// System.out.println(n[0] + " " + costs[n[0]] + " " + ret);
			ret += costs[n];
			if(left > right) continue;
			if(n < left) {
				q.add(left++);
			} else {
				q.add(right--);
			}
		}

		return ret; 
	}
}
