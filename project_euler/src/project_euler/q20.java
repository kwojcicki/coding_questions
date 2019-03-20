package project_euler;

import java.math.BigInteger;

public class q20 {

	/**
	 *
n! means n × (n - 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
	 */
	public static void main(String[] args) {

		BigInteger x = BigInteger.valueOf(100);
		for(int i = 99; i > 0; i--) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(x);
		int sum = 0;
		for(char c: x.toString().toCharArray()){
			sum += c - '0';
		}
		System.out.println(sum);
	}
	
}
