package project_euler;

public class q36 {

	/**
	 *
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
	 */
	public static void main(String[] args) {

		long sum = 0;
		for(int i = 1; i < 1_000_000; i++) {
			if(isPalindrome(Integer.toString(i), Integer.toBinaryString(i))) {
				sum += i;
			}
		}

		System.out.println(sum);
	}
	
	public static boolean isPalindrome(String s, String s1) {
		
		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		
		for(int i = 0; i < s1.length() / 2; i++) {
			if(s1.charAt(i) != s1.charAt(s1.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
}
