package solutions;

public class maximum_length_of_repeated_subarray {
    public int findLength(int[] nums1, int[] nums2) {
    	int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 1; j < dp[i].length; j++) {
        		if(nums1[i - 1] == nums2[j - 1]) {
        			dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
        		}
        	}
            // System.out.println(Arrays.toString(dp[i]) + (i - 1));
        }
        
        return max; 
    }
}
