package solutions;
class maximum_number_of_jumps_to_reach_the_last_index {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        for(int i = nums.length - 2; i >= 0; i--){
            dp[i] = -1;
            for(int j = i + 1; j < nums.length; j++){
                if(dp[j] != -1 && Math.abs(nums[j] - nums[i]) <= target){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0];
    }
}
