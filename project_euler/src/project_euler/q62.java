package project_euler;

import java.util.HashMap;

public class q62 {

	/**
	 *
The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.
	 */
	public static void main(String[] args) {

		HashMap<String, long[]> count = new HashMap<String, long[]>();

		for(long i = 1; i < 1_000_000; i++) {
			String s = Long.toString(i * i * i).chars()
					.sorted()
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.reverse()
					.toString();
			count.putIfAbsent(s, new long[] {0, i * i * i});
			count.compute(s, (k, v) -> {
				v[0]++;
				return v;
			});
			if(count.get(s)[0] == 5) {
				System.out.println(i + " " + s + " " + count.get(s)[1]);
				break;
			}
		}

	}
}
