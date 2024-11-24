package solutions;

public class maximum_matrix_sum {
    public long maxMatrixSum(int[][] matrix) {
        long ret = 0;
        int odds = 0;
        int l1 = matrix[0][0];

        for(int[] i: matrix){
            for(int j: i){
                ret += Math.abs(j);
                if(l1 == 0) continue;
                if(j < 0)  odds++;
                if(j == 0){
                    l1 = 0;
                } else if(Math.abs(j) < Math.abs(l1)){
                    l1 = j;
                }
            }
        }

        if(odds % 2 == 1) ret -= Math.abs(l1) * 2;

        return ret;
    }
}
