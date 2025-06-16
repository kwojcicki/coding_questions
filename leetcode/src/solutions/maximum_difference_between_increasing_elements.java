package solutions;

public class maximum_difference_between_increasing_elements {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ret = -1;

        for(int i = 1; i < nums.length; i++){
            ret = Math.max(ret, nums[i] - min);
            min = Math.min(min, nums[i]);
        }

        return ret == 0 ? -1 : ret;
    }
}
