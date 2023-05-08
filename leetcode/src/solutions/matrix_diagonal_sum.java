package solutions;

public class matrix_diagonal_sum {
    public int diagonalSum(int[][] mat) {
        int ret = 0;
        
        for(int i = 0; i < mat.length; i++) {
        	ret += mat[i][i];
        	ret += mat[i][mat.length - 1 - i];
        }
        
        return ret - (mat.length % 2 == 1 ? 
        		mat[mat.length / 2][mat.length / 2]: 0);
    }
}
