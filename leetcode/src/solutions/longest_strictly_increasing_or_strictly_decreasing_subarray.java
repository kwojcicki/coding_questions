package solutions;

public class longest_strictly_increasing_or_strictly_decreasing_subarray {
    public int longestMonotonicSubarray(int[] nums) {
        int ret = 1;
        int curr = 1;
        boolean increasing = false;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1] && increasing){
                curr++;
            } else if(nums[i]  < nums[i - 1] && !increasing){
                curr++;
            } else {
                ret = Math.max(ret, curr);
                if(nums[i] == nums[i - 1]) curr = 1;
                else curr = 2;

                if(nums[i] > nums[i - 1]) increasing = true;
                else increasing = false;
            }
            // System.out.println(i + " " + increasing + " " + curr);
        }

        return Math.max(ret, curr);
    }
}
