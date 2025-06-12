package solutions;

public class maximum_difference_between_adjacent_elements_in_a_circular_array {
    public int maxAdjacentDistance(int[] nums) {
        int ret = Math.abs(nums[0] - nums[nums.length - 1]);
        
        for(int i = 0; i < nums.length - 1; i++) {
        	ret = Math.max(ret, Math.abs(nums[i] - nums[i + 1]));
        }
        
        return ret;
    }
}
