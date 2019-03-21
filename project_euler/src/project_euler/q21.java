package project_euler;

import java.util.ArrayList;

public class q21 {

	/**
	 *
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
	 */
	public static void main(String[] args) {

		int sum = 0;
//		System.out.println(divisors(220));
//		System.out.println(divisors(220).stream().mapToInt(j -> j.intValue()).sum());
		for(int i = 2; i < 10_000; i++) {
			ArrayList<Integer> divisors = divisors(i);
			int summation = divisors.stream().mapToInt(j -> j.intValue()).sum();
			ArrayList<Integer> divisors1 = divisors(summation);
			if(summation > i && divisors1.stream().mapToInt(j ->j.intValue()).sum() == i) {
				sum += i + summation;
			}
		}
		
		System.out.println(sum);
	}
	
	public static ArrayList<Integer> divisors(int i){
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		toReturn.add(1);
		
		for(int j = 2;j < Math.sqrt(i) + 1; j++) {
			if(i % j == 0) {
				toReturn.add(j);
				toReturn.add(i / j);
			}
		}
		
		return toReturn;
	}
	
}
