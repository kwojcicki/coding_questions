package solutions;

public class search_a_2d_matrix_ii {
	public boolean searchMatrix(int[][] matrix, int target) {
		int r = 0, c = matrix[0].length;

		while(r < matrix.length && c >= 0) {
			if(matrix[r][c] == target) return true;
			if(matrix[r][c] > target) {
				c--;
			} else {
				r++;
			}
		}

		return false;
	}
}
