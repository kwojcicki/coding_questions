package project_euler;

import java.math.BigInteger;

public class q16 {

	/**
	 *
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?
	 */
	public static void main(String[] args) {

		System.out.println(BigInteger.ONE.add(BigInteger.ONE).pow(1000));
		String x = BigInteger.ONE.add(BigInteger.ONE).pow(1000).toString(10);
		System.out.println(x);
		long sum = 0;
		for(char c: x.toCharArray()) {
			sum += c - '0';
		}
		System.out.println(sum);
	}
	
}
