package project_euler;

public class q40 {

	/**
	 *
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	 */
	public static void main(String[] args) {

		int sum = 0;

		StringBuilder s = new StringBuilder();

		for(int i = 1; s.length() < 1_000_000; i++) {
			s.append(i + "");
		}

		sum = (s.charAt(1 - 1) - '0') *
				(s.charAt(10 - 1) - '0') *
				(s.charAt(100 - 1) - '0') *
				(s.charAt(1000 - 1) - '0') *
				(s.charAt(10000 - 1) - '0') *
				(s.charAt(100000 - 1) - '0') *
				(s.charAt(1000000 - 1) - '0');
		
		System.out.println(s.charAt(1 - 0));

		System.out.println(sum);
	}


}
