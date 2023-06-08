package solutions;

public class count_negative_numbers_in_a_sorted_matrix {
    public int countNegatives(int[][] grid) {
        int ret = 0;
        int start = grid[0].length;

        for(int i = 0; i < grid.length; i++){
            int j = start - 1;
            ret += (grid[0].length - 1 - j);
            while(j >= 0 && grid[i][j] < 0){
                j--;
                ret++;
                start--;
            }
        }


       return ret;
    }
}
