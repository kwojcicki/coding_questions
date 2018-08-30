package solutions.mathematics.reverse_game;

import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for(int i = 0; i < t; i++) {
			String[] nk = scanner.nextLine().split(" ");
			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);
			System.out.println((k >= n / 2) ? (n - 1 - k) * 2 : 2 * k + 1);

		}
		scanner.close();
	}
}