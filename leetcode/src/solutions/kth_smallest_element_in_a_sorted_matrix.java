package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class kth_smallest_element_in_a_sorted_matrix {
	public int kthSmallest(int[][] matrix, int k) {
		Queue<int[]> q = new PriorityQueue<>((a,b) -> {
			return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]);
		});
		for(int i = 0; i < matrix.length; i++) q.add(new int[] {i, 0});

		while(true) {
			int[] n = q.poll();
			if(--k == 0) {
				return matrix[n[0]][n[1]];
			}

			if(n[1] + 1 < matrix[0].length) q.add(new int[] {n[0], n[1] + 1});
		}
	}
}
