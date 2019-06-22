package top_interview_medium.others;

import java.util.Comparator;
import java.util.PriorityQueue;

public class k_closest_points_to_origin {
	public int[][] kClosest(int[][] points, int K) {

		PriorityQueue<int[]> x = new PriorityQueue<int[]>(K, new Comparator<int[]>() {
			public int compare(int[] x1, int[] x2) {
				return Integer.compare(x1[0]*x1[0] + x1[1]*x1[1], x2[0]*x2[0] + x2[1] * x2[1]);
			}
		});
		
		for(int[] p: points) {
			x.add(p);
		}
		
		int[][] toReturn = new int[K][2];
		for(int i = 0; i < K; i++) {
			toReturn[i] = x.poll();
		}
		
		return toReturn;
	}
}
