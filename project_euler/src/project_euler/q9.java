package project_euler;

public class q9 {

	/**
	 *
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
	 */
	public static void main(String[] args) {

		for(int i = 1; i < 999; i++) {
			for(int j = 1; j < 999; j++) {
				for(int k = 1; k < 999; k++) {
					
					if(i * i + j * j == k * k) {
						if(i + j + k == 1000) {
							System.out.println(i + " " + j + " " + k);
							System.out.println(i * j * k);
						}
					}
					
				}
			}
		}

	}

}
