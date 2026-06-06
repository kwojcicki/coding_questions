package solutions;

class left_and_right_sum_differences {
    public int[] leftRightDifference(int[] nums) {
        int[] ret = new int[nums.length];
        int right = 0;
        for(int i: nums) right += i;

        int left = 0;
        for(int i = 0; i < nums.length; i++){
            right -= nums[i];
            ret[i] = (int) Math.abs(left - right);
            left += nums[i];
        }

        return ret;
    }
}
