package solutions;

import java.util.Arrays;

public class champagne_tower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[] curr = new double[100];
		double[] next = new double[100];

		curr[99] = poured;

		for(int i = 0; i < query_row; i++) {

			for(int j = 99 - i; j <= 99; j++) {

				if(curr[j] > 1){
					double overflow = (curr[j] - 1) / 2.0;
					next[j - 1] += overflow;
					next[j] += overflow;   
				}
			}

			curr = next;
			next = new double[100];

		}

		System.out.println(Arrays.toString(curr));
		System.out.println(Arrays.toString(next));
		return (curr[99 - query_glass] > 1 ? 1 : curr[99 - query_glass]);
	}
}
