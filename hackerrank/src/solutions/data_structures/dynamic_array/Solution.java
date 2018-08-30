package solutions.data_structures.dynamic_array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

	/*
	 * Complete the dynamicArray function below.
	 */
	static int[] dynamicArray(int n, int[][] queries) {
		int lastAnswer = 0;

		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
		IntStream.range(0, n).forEach(i -> seqList.add(new ArrayList<Integer>()));

		for(int i = 0; i < queries.length; i++) {
			if(queries[i][0] == 1) {
				seqList.get((queries[i][1] ^ lastAnswer) % n).add(queries[i][2]);
			} else {
				ArrayList<Integer> seq = seqList.get((queries[i][1] ^ lastAnswer) % n);
				lastAnswer = seq.get(queries[i][2] %  seq.size()).intValue();
				toReturn.add(lastAnswer);
			}
		}

		return toReturn.stream().mapToInt(i->i).toArray();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nq = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nq[0].trim());

		int q = Integer.parseInt(nq[1].trim());

		int[][] queries = new int[q][3];

		for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
				int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = dynamicArray(n, queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}