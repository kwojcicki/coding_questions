package project_euler;

import java.math.BigInteger;

public class q3 {

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
	 * @param args
	 */
	public static void main(String[] args) {
		long big = new BigInteger("600851475143").longValue();
		for(long i = new BigInteger("600851475143").longValue() / 2; i > 2; i--) {
			if(big % i == 0) {
				if(BigInteger.valueOf(i).isProbablePrime(10)) {
					System.out.println(i);
					break;
				} else {
					System.out.println("not prime: " + i);
				}
			}
		}

	}

}
