package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class queue_reconstruction_by_height {

	public int[][] reconstructQueue(int[][] people) {
		List<int[]> ret = new ArrayList<>(people.length);

		Arrays.sort(people, Comparator.<int[]>comparingInt(p -> - p[0]).
				thenComparing(Comparator.comparingInt(p -> p[1])));

		for(int[] p: people) {
			ret.add(p[1], p);
		}
		
		return ret.toArray(new int[ret.size()][2]);
	}
	
	public int[][] reconstructQueue1(int[][] people) {
		List<int[]> ret = new ArrayList<>(people.length);

		Arrays.sort(people, Comparator.<int[]>comparingInt(p -> p[1]).
				thenComparing(Comparator.comparingInt(p -> p[0])));

		for(int[] p: people) {
			int count = p[1];
			int index = 0;
			while(index < ret.size() && (p[0] > ret.get(index)[0] || count > 0)) {
				if(p[0] <= ret.get(index)[0]) count--;
				index++;
			}

			ret.add(index, p);
		}

		return ret.toArray(new int[ret.size()][2]);
	}
}
