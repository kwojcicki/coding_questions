package solutions;

import java.math.BigInteger;

public class power_of_two {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        BigInteger n1 = BigInteger.valueOf(n);
        System.out.println(n1.subtract(BigInteger.ONE).toString());
        System.out.println(n1.and(n1.subtract(BigInteger.ONE)));
        return n1.and(n1.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
    }
    

    public boolean isPowerOfTwo1(int n) {
    	return n > 0 && (n & (n-1)) == 0;
    }
}
