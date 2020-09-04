package solutions;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<>();
		if(matrix.length == 0) return ret;
		int r1 = 0;
		int r2 = matrix.length - 1;
		int c1 = 0;
		int c2 = matrix[0].length - 1;
		
		while(r1 <= r2 && c1 <= c2) {
			
			for(int i = c1; i <= c2; i++) ret.add(matrix[r1][i]);
			for(int i = r1 + 1; i <= r2; i++) ret.add(matrix[i][c2]);
			
			if(r1 < r2 && c1 < c2) {
				for(int i = c2 - 1; i > c1; i--) ret.add(matrix[r2][i]);
				for(int i = r2; i > r1; i--) ret.add(matrix[i][c1]);
			}
			
			r1++;
			r2--;
			c1++;
			c2--;
			
		}
		
		
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] {
			{1,2,3},
			{5,6,7},
			{4,8,9}
		}));

		System.out.println(spiralOrder(new int[][] {
			{2, 3}
		}));		

		System.out.println(spiralOrder(new int[][] {
			{6, 9, 7}
		}));
		
		System.out.println(spiralOrder(new int[][] {
			{3},
			{2}
		}));
	}
}
