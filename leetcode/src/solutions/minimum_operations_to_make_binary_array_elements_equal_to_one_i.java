package solutions;

public class minimum_operations_to_make_binary_array_elements_equal_to_one_i {
    public int minOperations(int[] nums) {
        int ret = 0;
        int len = nums.length;
        
        for(int i = 0; i < len - 2; i++) {
        	if(nums[i] == 1) continue;
        	ret++;
        	nums[i + 1] = 1 - nums[i + 1];
        	nums[i + 2] = 1 - nums[i + 2];
        }
        
        return nums[len - 1] == 1 && nums[len - 2] == 1 ? ret : -1;
    }
}
