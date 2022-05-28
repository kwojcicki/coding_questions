package solutions;

import java.util.Arrays;

public class zeroone_matrix {

    public int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        int bigNumber = Integer.MAX_VALUE - 10000;
        
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = 0; j < dp[i].length; j++){
                if(mat[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }
                
                dp[i][j] = Math.min(  
                    i > 0 ? dp[i - 1][j] : bigNumber,
                    j > 0 ? dp[i][j - 1] : bigNumber
                ) + 1;
            }
        }
        
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[i].length - 1; j >= 0; j--){
                if(mat[i][j] == 0){
                    continue;
                }
                
                dp[i][j] = Math.min(dp[i][j], Math.min(  
                    i < dp.length - 1 ? dp[i + 1][j] : bigNumber,
                    j < dp[i].length - 1 ? dp[i][j + 1] : bigNumber
                ) + 1);
            }
        }
        
        return dp;
    }
}
