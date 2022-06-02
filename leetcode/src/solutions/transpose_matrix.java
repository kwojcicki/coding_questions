package solutions;

public class transpose_matrix {
    public int[][] transpose(int[][] matrix) {
        int[][] ret = new int[matrix[0].length][matrix.length];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ret[j][i] = matrix[i][j];
            }
        }
        
        return ret;
    }
}
