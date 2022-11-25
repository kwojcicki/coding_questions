package solutions;

import java.util.Stack;

public class sum_of_subarray_minimums {
    public int sumSubarrayMins(int[] arr) {
    	long ret = 0;
        long mod = (long) (1E9 + 7);
        
        Stack<long[]> s = new Stack<>();
        long currSum = 0;
        for(int i: arr) {
        	long count = 1;
        	
        	currSum += i;
        	while(!s.isEmpty() && s.peek()[0] > i) {
        		currSum -= (s.peek()[0] - i) * s.peek()[1];
        		count += s.pop()[1];
        	}
        	ret = (ret + currSum) % mod;
        	s.push(new long[] {i, count});
        	// System.out.println(ret);
        }
        
        return (int)(ret % mod);
    }
}
