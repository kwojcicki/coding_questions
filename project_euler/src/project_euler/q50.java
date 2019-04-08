package project_euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class q50 {

	/**
	 *
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
	 */
	public static void main(String[] args) {
		boolean[] seen = new boolean[1_000_001];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Set<Long> primesSet = new HashSet<Long>();
		for(int i = 2; i < seen.length; i++) {
			if(!seen[i - 2]) {
				primes.add(i);
				primesSet.add((long)i);
			}
			
			for(int j = i - 2; j < seen.length; j += i) {
				seen[j] = true;
			}
		}
		
		long maxPrime = 0;
		int terms = 0;
		
		for(int i = 0; i < primes.size(); i++) {
			
			long sum = primes.get(i);
			int termsCurr = 1;
			for(int j = i + 1; sum < 1_000_000 && j < primes.size(); j++) {
				if(termsCurr > terms && primesSet.contains((long)sum)) {
					terms = termsCurr;
					maxPrime = sum;
				}
				termsCurr++;
				sum += primes.get(j);
			}
		}
		
		System.out.println(maxPrime + " " + terms);
	}
}
