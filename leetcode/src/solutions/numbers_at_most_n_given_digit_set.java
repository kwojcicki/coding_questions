package solutions;

public class numbers_at_most_n_given_digit_set {
    public int atMostNGivenDigitSet(String[] digits, int n) {
    	
    	if(digits == null || digits.length == 0) return 0;
    	
        int ret = 0;
        
        int[] dgs = new int[digits.length];
        
        for(int i = 0; i < digits.length; i++) dgs[i] = digits[i].charAt(0) - '0';
        
        for(int i: dgs) {
        	ret += helper(dgs, n, i);
        }
        
        return ret;
    }
    
    public int helper(int[] digits, int n, int curr) {
    	
    	int ret = 0;
    	
    	if(curr <= n) ret++;
    	
    	for(int i: digits) {
    		ret += helper(digits, n, curr + i);
    	}
    	
    	return ret;
    }
}
