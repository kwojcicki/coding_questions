package project_euler;

public class q10 {

	/**
	 *
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
	 */
	public static void main(String[] args) {

		boolean[] seen = new boolean[2_000_000 - 2];
		long sum = 0;
		int seive = 2;
		
		while(seive != 2_000_000) {
			if(!seen[seive - 2]) {
				//System.out.println(seive);
				sum += seive;
			}
			
			for(int i = seive - 2; i < seen.length; i+= seive) {
				seen[i] = true;
			}
			seive++;
		}
		
		
		
		System.out.println(sum);

	}

}
