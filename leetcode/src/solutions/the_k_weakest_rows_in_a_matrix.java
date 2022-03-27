package solutions;

import java.util.PriorityQueue;

public class the_k_weakest_rows_in_a_matrix {
	public int[] kWeakestRows(int[][] mat, int k) {
		int[] ret = new int[k];

		PriorityQueue<Integer[]> q = new PriorityQueue<Integer[]>((a,b) -> {
			if(a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}

			return Integer.compare(a[0], b[0]);
		});

		int index = 0;
		for(int[] m: mat) {
			q.add(new Integer[] { bs(m), index});
			index++;
		}

		for(int i = 0; i < k; i++) {
			ret[i] = q.poll()[1];
		}

		return ret;
	}

	public int bs(int[] m) {
		int start = 0;
		int end = m.length;
		int mid;
		while(start < end) {
			mid = (end - start) / 2 + start;

			if(m[mid] == 0) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}
