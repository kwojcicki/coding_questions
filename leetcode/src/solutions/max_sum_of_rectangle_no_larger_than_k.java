package solutions;

import java.util.TreeSet;

public class max_sum_of_rectangle_no_larger_than_k {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int ret = Integer.MIN_VALUE;

		int[][] sum = new int[matrix.length + 1][matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				sum[i + 1][j] = matrix[i][j] + sum[i][j];
			}
		}

		for(int i = 1; i < sum.length; i++) {
			for(int j = i; j < sum.length; j++) {
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				int s = 0;
				for(int col = 0; col < sum[i].length; col++) {
					s += sum[j][col] - sum[i - 1][col];
					Integer r =  set.ceiling(s - k);
					// System.out.print(s + " " + r + ", ");
					if(r != null && s - r <= k) ret = Math.max(s - r, ret);
					set.add(s);
				}
				// System.out.println("i,j: " + i + " " + j + " " + ret);
			}
		}

		return ret;
	}
}
