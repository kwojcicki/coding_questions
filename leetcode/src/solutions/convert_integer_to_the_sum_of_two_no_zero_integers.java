package solutions;

public class convert_integer_to_the_sum_of_two_no_zero_integers {
	public int[] getNoZeroIntegers(int n) {
        int left = 0, right = 0;
        int exponent = 1;
        while(n > 0) {
        	int d = n % 10;
        	n /= 10;
        	
        	if((d == 1 || d == 0) && n > 0) {
        		left += exponent * (1 + d);
        		right += exponent * 9;
        		n--;
        	} else {
        		left += exponent * 1;
        		right += exponent * (d - 1);
        	}
        	
        	exponent *= 10;
        }
        
        return new int[] {left, right};
    }
}
