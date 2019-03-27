package project_euler;

import java.util.HashSet;

public class q35 {

	/**
	 *
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
	 */
	public static void main(String[] args) {

		boolean[] seen = new boolean[1_000_000 - 2];
		HashSet<Integer> primes = new HashSet<Integer>();
		for(int i = 2; i < seen.length; i++) {
			if(!seen[i - 2]) {
				primes.add(i);
			}
			for(int j = i - 2; j < seen.length; j+=i) {
				seen[j] = true;
			}
		}
		
		int count = 0;
		
		outerloop:
		for(int i: primes) {
			String s = Integer.toString(i);
			//System.out.println("s: " + s);
			for(int j = 1; j < s.length(); j++) {
				//System.out.println(s.substring(s.length() - j, s.length()) + s.substring(0, s.length() - j));
				if(!primes.contains(Integer.parseInt(s.substring(s.length() - j, s.length()) + s.substring(0, s.length() - j)))) {
					continue outerloop;
				}
			}
			
			//System.out.println("circular: " + i);
			count++;
		}
		System.out.println(count);
	}
}
