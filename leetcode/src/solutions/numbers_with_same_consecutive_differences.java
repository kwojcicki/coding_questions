package solutions;

import java.util.ArrayList;
import java.util.List;

public class numbers_with_same_consecutive_differences {
	public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ret = new ArrayList<>();
        
        for(int i = 1; i < 10; i++) {
        	helper(i, i, n - 1, k, ret);
        }
        
        return ret.stream().mapToInt(i -> i).toArray();
    }
    
    public void helper(int curr, int prev, int length, int k, List<Integer> ret) {
    	if(length == 0) {
    		ret.add(curr);
    		return;
    	}
    	
    	if(prev + k < 10) helper(curr * 10 + (prev + k), (prev + k), length - 1, k, ret);
    	if(prev - k >= 0 && k != 0) helper(curr * 10 + (prev - k), (prev - k), length - 1, k, ret);
    }
}
