package project_euler;

public class q30 {

	/**
	 *
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 */
	public static void main(String[] args) {

		int n = 10;
		int pow = 5;
		int summation = 0;

		while(n < 1_000_000) {
			int sum = 0;
			//System.out.println(n + " " + Integer.toString(n));
			for(char c: Integer.toString(n).toCharArray()) {
				sum += Math.pow(c - '0', pow);
			}
			if(sum == n) {
				System.out.println(n);
				summation += n;
			}
			n++;
		}
		
		System.out.println(summation);
	}
}
