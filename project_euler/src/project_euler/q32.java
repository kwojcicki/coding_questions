package project_euler;

import java.util.Arrays;
import java.util.HashSet;

public class q32 {

	/**
	 *
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
	 */
	public static void main(String[] args) {

		long sum = 0;
		HashSet<Long> seen = new HashSet<Long>();

		for(long i = 1; i < 10_000; i++) {
			for(long j = 1; j < 10_000; j++) {
				long total = i * j;
				boolean[] chars = new boolean[10];

				if(Long.toString(i).length() + Long.toString(j).length() + Long.toString(total).length() == 9) {
					for(char c: Long.toString(i).toCharArray()) {
						chars[c - '0'] = true;
					}
					for(char c: Long.toString(j).toCharArray()) {
						chars[c - '0'] = true;
					}
					for(char c: Long.toString(total).toCharArray()) {
						chars[c - '0'] = true;
					}

					boolean flag = !chars[0] && chars[1] && chars[2] && chars[3] && chars[4] && chars[5] && chars[6] && chars[7] && chars[8] && chars[9];
					if(flag && !seen.contains(total)) {
						System.out.println(Arrays.toString(chars));
						System.out.println(i + " " + j + " " + total);
						sum += total;
						seen.add(total);
					}
				}
			}
		}


		System.out.println(sum);
	}
}
