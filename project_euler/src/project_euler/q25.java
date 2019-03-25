package project_euler;

import java.math.BigInteger;

public class q25 {

	/**
	 *
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
	 */
	public static void main(String[] args) {

		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		int i = 1;
		while(true) {
			if(f1.toString().length() == 1000) {
				System.out.println(i);
				break;
			}
			BigInteger temp = f2.add(f1);
			f1 = f2;
			f2 = temp;
			i++;
		}
	}
}
