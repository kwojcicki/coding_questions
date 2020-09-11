package solutions;

public class maximum_product_subarray {
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
        	
        	int curr = nums[i];
            int temp = maxSoFar;
            
        	maxSoFar = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
        	minSoFar = Math.min(curr, Math.min(temp * curr, minSoFar * curr));
        	
        	max = Math.max(max, maxSoFar);
        	
        }
        
        
        return max;
    }
    
    public static void main(String[] args) {
    	System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
    }
}
