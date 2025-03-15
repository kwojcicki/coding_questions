package solutions;

public class maximum_candies_allocated_to_k_children {
    public int maximumCandies(int[] candies, long k) {
        int ret = 0;
    	
    	int low = 1, high = 10_000_000;
    	
    	while(low <= high) {
    		int mid = (high + low) / 2;
    		long groups = 0;
    		
    		for(int i: candies) groups += i / mid;
    		
            // System.out.println(high + " " + mid + " " + low + " " + groups);
    		if(groups >= k) {
    			ret = mid;
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	
    	return ret;
    }
}
