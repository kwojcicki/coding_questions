package solutions;

import java.util.HashMap;
import java.util.Map;

public class tuple_with_same_product {
	
	public long factorial(int n) {
		return n == 0 ? 1 : n * factorial(n - 1);
	}
	
    public int tupleSameProduct(int[] nums) {
        int ret = 0;
        
        Map<Integer, Integer> products = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i + 1; j < nums.length; j++) {
        		products.compute(nums[i] * nums[j], (k,v) -> v == null ? 1 : v + 1);
        	}
        }
        
        for(int count: products.values()) {
        	if(count == 1) continue;
            // if(count > 10) System.out.println(count);
        	ret += (factorial(count) / factorial(count - 2)) * 4;
        }
        
        return ret;
    }
}
