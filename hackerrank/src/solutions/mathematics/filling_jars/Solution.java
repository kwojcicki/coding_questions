package solutions.mathematics.filling_jars;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long M = sc.nextInt();
		long N = sc.nextInt();

		long sum = 0;
		for(int i = 0;i < N;i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long k = sc.nextLong();
			sum += (b - a + 1) * k;
		}

		System.out.println(sum/M);
		sc.close();
	}
}