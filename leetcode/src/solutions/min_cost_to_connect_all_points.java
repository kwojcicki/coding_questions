package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class min_cost_to_connect_all_points {
	
	public int find(int[] union, int i) {
		return union[i] < 0 ? i : find(union, union[i]);
	}
	
	public int minCostConnectPoints(int[][] points) {
		if(points == null || points.length == 1) return 0;

		int[] union = new int[points.length];
		Arrays.fill(union, -1);
		PriorityQueue<Integer[]> q = new PriorityQueue<>((a,b) -> {
			return Integer.compare(a[0], b[0]);
		});

		for(int i = 0; i < points.length; i++) {
			for(int j = i + 1; j < points.length; j++) {
				q.add(new Integer[] {Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j});
			}
		}

		int sum = 0;

		while(true) {
			Integer[] n = q.poll();
			
			int i = find(union, n[1]);
			int j = find(union, n[2]);
			
			if(i != j) {
				union[i] += union[j];
				union[j] = i;
				sum += n[0];
				if(union[i] == points.length * -1) return sum;
			}
		}
	}
}
