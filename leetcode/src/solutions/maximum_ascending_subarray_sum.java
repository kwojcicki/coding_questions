package solutions;

public class maximum_ascending_subarray_sum {
    public int maxAscendingSum(int[] nums) {
        int ret = 0;
        int curr = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                curr += nums[i];
            } else {
                ret = Math.max(ret, curr);
                curr = nums[i];
            }
        }

        return Math.max(ret, curr);
    }
}
