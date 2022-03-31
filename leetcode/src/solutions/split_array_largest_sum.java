package solutions;

public class split_array_largest_sum {

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        
        for(int i: nums) {
        	start = Math.max(start, i);
        	end += i;
        }
        
        while(start < end) {
        	int mid = (end - start) / 2 + start;
        	
        	if(test(mid, nums, m)) {
        		end = mid;
        	} else {
        		start = mid + 1;
        	}
        }
        
        return end;
    }
    
    public boolean test(int max, int[] nums, int m) {
    	int sum = 0;
    	
    	for(int i: nums) {
    		if(sum + i <= max) {
    			sum += i;
    		} else {
    			m--;
    			sum = i;
    			if(m == 0) return false;
    		}
    	}
    	
    	return true;
    }
}
