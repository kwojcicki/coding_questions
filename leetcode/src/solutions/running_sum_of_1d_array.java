package solutions;

public class running_sum_of_1d_array {
    public int[] runningSum(int[] nums) {
        int[] ret = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            ret[i] = sum;
        }
        
        return ret;
    }
}
