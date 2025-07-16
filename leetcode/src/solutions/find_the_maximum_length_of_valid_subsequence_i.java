package solutions;

public class find_the_maximum_length_of_valid_subsequence_i {
    public int maximumLength(int[] nums) {
        int ret = 0, odds = 0, evens = 0;
        boolean evenLast = false;
        
        for(int n: nums) {
        	if(n % 2 == 0) evens++; else odds++;
        	if(ret == 0) {
        		ret++;
        		evenLast = n % 2 == 0;
        	} else if((n % 2 == 0) != evenLast) {
        		ret++;
        		evenLast = !evenLast;
        	}
        }
        
        // System.out.println(ret + " " + odds + " " + evens);
        return Math.max(ret, Math.max(odds, evens));
    }
}
