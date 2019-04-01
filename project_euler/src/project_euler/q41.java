package project_euler;

import java.math.BigInteger;

public class q41 {

	/**
	 *
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
	 */
	public static void main(String[] args) {

		BigInteger i = BigInteger.valueOf(1_00_000_000);

		while(true) {
			i = i.subtract(BigInteger.ONE);
			String s = i.toString();
			//System.out.println(s);
			if(s.length() == 9 && 
					s.indexOf('1') >= 0 && 
					s.indexOf('2') >= 0 && 
					s.indexOf('3') >= 0 && 
					s.indexOf('4') >= 0 && 
					s.indexOf('5') >= 0 && 
					s.indexOf('6') >= 0 && 
					s.indexOf('7') >= 0 && 
					s.indexOf('8') >= 0 && 
					s.indexOf('9') >= 0 && i.isProbablePrime(1000)) {

				System.out.println(s);
				break;

			} else if (s.length() == 8 && 
					s.indexOf('1') >= 0 && 
					s.indexOf('2') >= 0 && 
					s.indexOf('3') >= 0 && 
					s.indexOf('4') >= 0 && 
					s.indexOf('5') >= 0 && 
					s.indexOf('6') >= 0 && 
					s.indexOf('7') >= 0 && 
					s.indexOf('8') >= 0 && i.isProbablePrime(1000)) {

				System.out.println(s);
				break;
			} else if (s.length() == 7 && 
					s.indexOf('1') >= 0 && 
					s.indexOf('2') >= 0 && 
					s.indexOf('3') >= 0 && 
					s.indexOf('4') >= 0 && 
					s.indexOf('5') >= 0 && 
					s.indexOf('6') >= 0 && 
					s.indexOf('7') >= 0 && i.isProbablePrime(1000)) {

				System.out.println(s);
				break;
			} else if(s.length() < 7) {
				System.out.println("not found");
				break;
			}
		}


	}


}
