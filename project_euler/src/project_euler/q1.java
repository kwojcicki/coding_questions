package project_euler;

import java.util.stream.IntStream;

public class q1 {

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
		Find the sum of all the multiples of 3 or 5 below 1000.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(IntStream.range(0, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum());
	}

}
