package project_euler;

import java.util.ArrayList;
import java.util.HashSet;

public class q23 {

	/**
	 *
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
	 */
	public static void main(String[] args) {

		int sum = 0;
		//HashSet<Integer> sums = new HashSet<Integer>();
		HashSet<Integer> abundants = new HashSet<Integer>();
		
		for(int i = 1; i < 28_124; i++) {
			ArrayList<Integer> divs = divisors(i);
			final int k = i;
			if(!abundants.stream().filter(j -> abundants.contains(k - j)).findFirst().isPresent()) {
				sum += i;
				System.out.println("Cant be created: " + i);
			}
			if(divs.stream().mapToInt(j -> j).sum() > i) {
				System.out.println("abundant: " + i + " " + divs.toString());
				//final int k = i;
				//abundants.forEach(j -> sums.add(j + k));
				abundants.add(i);
			}
		}
		
		System.out.println(sum);
	}
	
	public static ArrayList<Integer> divisors(int i){
		HashSet<Integer> toReturn = new HashSet<Integer>();
		toReturn.add(1);
		
		for(int j = 2;j <= Math.sqrt(i) ; j++) {
			if(i % j == 0) {
				toReturn.add(j);
				toReturn.add(i / j);
			}
		}
		
		return new ArrayList<Integer>(toReturn);
	}
	
}
