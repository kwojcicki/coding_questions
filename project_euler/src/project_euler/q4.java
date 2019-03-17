package project_euler;

public class q4 {

	/**
	 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	public static void main(String[] args) {
		int maxPalindrom = Integer.MIN_VALUE;
		for(int i = 999; i > 100; i --) {
			for(int j = 999; j > 100; j--) {
				String sum = i * j + "";
				if(new StringBuilder(sum).reverse().toString().equals(sum)) {
					maxPalindrom = Math.max(maxPalindrom, i * j);
				}
			}
		}
		
		System.out.println(maxPalindrom);

	}

}
