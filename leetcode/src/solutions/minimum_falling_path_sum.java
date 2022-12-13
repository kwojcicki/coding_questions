package solutions;

import java.util.Arrays;

public class minimum_falling_path_sum {
    public int minFallingPathSum(int[][] A) {
    	int[] dp = new int[A[0].length + 2];
    	
    	dp[0] = 100_000;
    	dp[A[0].length - 1] = 100_00;
    	
    	for(int i = A.length - 1; i >= 0; i--) {
    		for(int j = 1; j < dp.length - 2; j++) {
    			dp[j] = A[i][j] + Math.min(dp[j - 1], 
    					Math.min(dp[j], dp[j + 1]));
    		}
    	}
    	
    	
    	return Arrays.stream(dp).min().getAsInt();
    }
    
    public int minFallingPathSum1(int[][] A) {
        
    	int[][] dp = new int[A.length][A[0].length];
    	
    	for(int i = 0; i < dp[0].length; i++) {
    		dp[A.length - 1][i] = A[A.length - 1][i];
    	}
    	
    	for(int i = 0; i < A.length; i++) {
    		System.out.println(Arrays.toString(dp[i]));
    	}
    	System.out.println("__");
    	
    	for(int i = A.length - 2; i >= 0; i--) {
    		for(int j = 0; j < A[0].length; j++) {
    			dp[i][j] = min(A, i, j, dp);
    		}
    	}
    	for(int i = 0; i < A.length; i++) {
    		System.out.println(Arrays.toString(dp[i]));
    	}
    	System.out.println("__");
    	
    	int min = dp[0][0];
    	
    	for(int a: dp[0]) {
    		min = Math.min(min, a);
    	}
    	
    	return min;
    }
    
    public static int min(int[][] A, int i, int j, int[][] dp) {
    	int ret = A[i][j] + dp[i + 1][j];
    	
    	if(j - 1 >= 0) {
    		ret = Math.min(ret, A[i][j] + dp[i + 1][j - 1]);
    	}
    	
    	if(j + 1 < A[0].length) {
    		ret = Math.min(ret, A[i][j] + dp[i + 1][j + 1]);
    	}
    	
    	return ret;
    }
    
    public static void main(String[] args) {
    	new minimum_falling_path_sum().minFallingPathSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }
}
