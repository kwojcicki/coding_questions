package solutions;

public class count_equal_and_divisible_pairs_in_an_array {
    public int countPairs(int[] nums, int k) {
        int ret = 0;
        
        for(int i = 0; i  < nums.length; i++) {
        	for(int j = i + 1; j < nums.length; j++) {
        		if(nums[i] == nums[j] && (i * j) % k == 0) ret++;
        	}
        }
        
        return ret;
    }
}
