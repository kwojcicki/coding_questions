package solutions;

public class find_the_smallest_divisor_given_a_threshold {
    public int smallestDivisor(int[] nums, int threshold) {
    	if(nums == null || nums.length == 0) return 0;
        int max = 0;
        
        for(int i: nums) {
        	max = Math.max(max, i);
        }
        
        int low = 1;
        int high = max;
        
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	int sum = divide(mid, nums);
        	        	//System.out.println(low + " " + high + " " + sum);
        	if(sum > threshold) {
        		low = mid + 1;
        	} else {
        		high = mid - 1;
        	}
        }
        
        return low;
    }
    
    public int divide(int d, int[] nums) {
    	int sum = 0;
    	double dividor = (double) d;
    	
    	for(int i: nums) {
    		sum += Math.ceil(i / dividor);
    	}
    	
    	return sum;
    }
}
