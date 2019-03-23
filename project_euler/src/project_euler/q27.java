package project_euler;

import java.util.HashSet;

public class q27 {

	/**
	 *
Euler discovered the remarkable quadratic formula:

n2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0<=n<=39. However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41 is clearly divisible by 41.

The incredible formula n2-79n+1601 was discovered, which produces 80 primes for the consecutive values 0<=n<=79. The product of the coefficients, -79 and 1601, is -126479.

Considering quadratics of the form:

n2+an+b, where |a|<1000 and |b|<=1000

where |n| is the modulus/absolute value of n
e.g. |11|=11 and |-4|=4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
	 */
	public static void main(String[] args) {

		boolean[] seen = new boolean[2_000_000];
		HashSet<Integer> primes = new HashSet<Integer>();
		
		for(int i = 2; i < seen.length; i++) {
			if(!seen[i - 2]) {
				primes.add(i);
			}
			for(int j = i - 2; j < seen.length; j += i) {
				seen[j] = true;
			}
		}
		
		//System.out.println(primes.toString());
		System.out.println("done seive");
		int maxPrimes = 0;
		int maxA = 0, maxB = 0;
		for(int a = -999; a < 1000; a++) {
			for(int b = -999; b < 1000; b++) {
				
				int n = 0;
				int prime = 0;
				while(true) {
					if(isPrime(n * n + a * n + b, primes)) {
						prime++;
						n++;
					} else {
						break;
					}
				}
				
				if(prime > maxPrimes) {
					maxPrimes = prime;
					maxA = a;
					maxB = b;
				}
			}
		}
		
		System.out.println(maxA * maxB);
		System.out.println(maxPrimes);
	}
	
	public static boolean isPrime(int n, HashSet<Integer> x) {
		return x.contains(n);
	}
}
