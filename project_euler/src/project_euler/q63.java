package project_euler;

import java.math.BigInteger;

public class q63 {

	/**
	 *
The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
	 */
	public static void main(String[] args) {

		int count = 0;
		
		for(int i = 1; i < 10000; i++) {
			for(int j = 1; j < 10; j++) {
				
				if(BigInteger.valueOf(j).pow(i).toString().length() == i) {
					count++;
					System.out.println(i + " " + j + " " +BigInteger.valueOf(j).pow(i).toString() + " " + BigInteger.valueOf(j).pow(i).toString().length());
				}
				
			}
		}
		
		System.out.println(count);
	}

}
