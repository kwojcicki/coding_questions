package solutions;

public class number_of_sub_arrays_with_odd_sum {
    public int numOfSubarrays(int[] arr) {
        long ret = 0;
        long mod = (long) (1e9 + 7);
        long evens = 0;
        long odds = 0;
        long sum = 0;
        
        for(int i: arr) {
        	sum += i;
        	if(sum % 2 == 0) {
        		ret = (ret + odds) %  mod;
        		evens++;
        	} else {
        		ret = (ret + evens + 1) %  mod;
        		odds++;
        	}
        }
        
        return (int) ret;
    }
}
