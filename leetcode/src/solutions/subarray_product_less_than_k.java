package solutions;

public class subarray_product_less_than_k {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int curr = 1;
        int count = 0;
        int ret = 0;
        int start = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	curr *= nums[i];
        	if(curr >= k) {
        		while(start <= i && curr >= k) {
        			curr /= nums[start];
            		start++;
            		count--;
        		}
        	}
        	
        	if(curr < k){
        		count++;
        	}
        	
        	System.out.println(i + " " + curr + " " + count + " " + ret);
        	if(curr < k) {
        		ret += count;
        	}
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
    }
}
