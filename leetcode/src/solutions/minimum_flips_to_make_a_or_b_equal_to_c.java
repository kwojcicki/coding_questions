package solutions;

public class minimum_flips_to_make_a_or_b_equal_to_c {
	public int minFlips(int a, int b, int c) {
		int flips = 0;

		while(a > 0 || b > 0 || c > 0) {

			int lastA = a & 1;
			int lastB = b & 1;
			int lastC = c & 1;

			if(lastC == 1){
				flips += ( (lastA | lastB) == 1 ? 0 : 1);     
			} else {
				flips += lastA + lastB; 
			}


			a >>= 1;
			b >>= 1;
			c >>= 1;
		}

		return flips;
	}
}
