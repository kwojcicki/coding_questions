package solutions;

public class sort_array_by_parity {

    public int[] sortArrayByParity(int[] nums) {
    	int low = 0, high = nums.length - 1;
    	
    	while(low < high) {
    		if(nums[low] % 2 == 0) {
    			low++;
    		} else {
    			int tmp = nums[high];
    			nums[high] = nums[low];
    			nums[low] = tmp;
    			high--;
    		}
    	}
    	
    	return nums;
    }
}
