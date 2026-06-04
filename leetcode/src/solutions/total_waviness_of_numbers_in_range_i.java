
package solutions;

class total_waviness_of_numbers_in_range_i {
    int ret = 0;

    public int helper(int[] dp, int i, int num1, int num2){
        if(i > num2) return 0;
        if(dp[i] != -1) return dp[i];

        int r = helper(dp, i / 10, num1, num2);
        dp[i] = r;

        int right = i % 10;
        int middle = (i / 10) % 10;
        int left = (i / 100) % 10;
        if(left > middle && middle < right) dp[i]++;
        else if(left < middle && middle > right) dp[i]++;

        if(i >= num1 && i <= num2) ret += dp[i];
        return dp[i];
    }

    public int totalWaviness(int num1, int num2) {
        if(num2 <= 100) return 0;
        int[] dp = new int[num2 + 1];
        Arrays.fill(dp, -1);
        for(int i = 0; i <= 100; i++) dp[i] = 0;
        for(int i = num1; i <= num2; i++){
            helper(dp, i, num1, num2);
        }

        return ret;
    }
}
