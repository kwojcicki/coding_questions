package solutions.mathematics.restaurant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	/*
	 * Complete the restaurant function below.
	 */
	static int restaurant(int l, int b) {
		int gcd=gcd(l,b);
		return ((l/gcd)*(b/gcd)) ;
	}

	static int gcd(int x,int y){ if(y==0){ return x; } return gcd(y,x%y); }



	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] lb = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			int l = Integer.parseInt(lb[0]);

			int b = Integer.parseInt(lb[1]);

			int result = restaurant(l, b);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}