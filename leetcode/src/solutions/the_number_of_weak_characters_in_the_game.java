package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class the_number_of_weak_characters_in_the_game {
	public int numberOfWeakCharacters(int[][] properties) {
		int ret = 0;

		Arrays.sort(properties, Comparator.<int[]>comparingInt(a -> -a[0]).
				thenComparing(Comparator.comparingInt(a -> a[1])));

		int maxSoFar = 0;

		for(int[] p: properties) {
			if(p[1] < maxSoFar) ret++;
			maxSoFar = Math.max(p[1], maxSoFar);
		}

		return ret;
	}
}
