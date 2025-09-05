package solutions;

public class minimum_operations_to_make_the_integer_zero {
    public int makeTheIntegerZero(int num1, int num2) {
        
    	for(int i = 0; i <= 60; i++) {
    		long target = num1 - i * (long) num2;
    		int bitCount = Long.bitCount(target);
    		if(target > 0 && bitCount <= i && i <= target) {
    			return i;
    		}
    	}
    	
    	return -1;
    }
}
