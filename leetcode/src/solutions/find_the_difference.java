package solutions;

public class find_the_difference {

	int[] primes = new int[] {
			2, 3, 5, 7, 11, 13, 
			17, 19, 23, 29, 31, 
			37, 41, 43, 47, 53, 
			59, 61, 67, 71, 73,
			79, 83, 89, 97, 101	
	};

	// alternative: xor/addition
	public char findTheDifference(String s, String t) {
		double sum = 1;

		for(int i = 0; i < s.length(); i++) {
			sum /= primes[s.charAt(i) - 'a'];
			sum *= primes[t.charAt(i) - 'a'];
		}

		sum *= primes[t.charAt(t.length() - 1) - 'a'];

		int sumy = (int) Math.round(sum);

		for(int i = 0; i < primes.length; i++) {
			if(sumy == primes[i]) {
				return (char)(i + 'a');
			}
		}

		return (char)(sum + 'a');
	}
}
