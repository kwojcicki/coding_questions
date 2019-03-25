package project_euler;

import java.util.stream.IntStream;

public class q34 {

	/**
	 *
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
	 */
	public static void main(String[] args) {

		long sum = 0;

		for(int i = 3; i < 1000000; i++) {
			int summation = 0;
			String s = Integer.toString(i);
			for(char c: s.toCharArray()) {
				summation += IntStream.range(1, (c - '0') + 1).reduce(1, (j, k) -> j * k);
			}
			
			if(summation == i) {
				System.out.println(i);
				sum += i;
			}
		}

		System.out.println(sum);
	}
}
