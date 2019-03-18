package project_euler;

public class q7 {

	/**
	 *
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
	 */
	public static void main(String[] args) {

		// p_n = n log (n) https://en.wikipedia.org/wiki/Prime_number_theorem
		
		boolean[] seen = new boolean[(int)(10001 * Math.log(10001) * 2)];
		int prime = 0;
		int lastPrime = 0;
		int seive = 2;
		
		while(prime != 10001) {
			if(!seen[seive - 2]) {
				prime++;
				lastPrime = seive;
			}
			
			for(int i = seive - 2; i < seen.length; i+= seive) {
				seen[i] = true;
			}
			seive++;
		}
		
		
		System.out.println(lastPrime);

	}

}
