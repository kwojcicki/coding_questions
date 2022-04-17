package solutions;

public class sort_an_array {
    public int[] sortArray(int[] nums) {
        sort(nums);
        return nums;
    }
    
    public void sort(int[] nums) {
    	sort(nums, 0, nums.length - 1);
    }
    
    public void sort(int[] nums, int low, int high) {
        if(low >= high) return;
    	int parition = (high + low) / 2;
    	int index = partition(nums, low, high, parition);
    	
    	sort(nums, low, index - 1);
    	sort(nums, index + 1, high);
    }
    
    public int partition(int[] nums, int low, int high, int partitionIndex) {
    	int parition = nums[partitionIndex];
    	int oldHigh = high;
    	swap(nums, partitionIndex, high);
    	high--;
    	
    	while(low <= high) {
    		if(nums[low] > parition) {
    			swap(nums, low, high);
    			high--;
    		} else {
    			low++;
    		}
    	}
    	
    	swap(nums, low, oldHigh);
    	
    	return low;
    }
    
    public void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    }
}
