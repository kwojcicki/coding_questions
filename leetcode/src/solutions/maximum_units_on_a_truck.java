package solutions;

import java.util.Arrays;
import java.util.Comparator;

public class maximum_units_on_a_truck {

	public int maximumUnits(int[][] boxTypes, int truckSize) {
		int[] count = new int[1001];
		int ret = 0;
		for(int[] box: boxTypes) {
			count[box[1]] += box[0];
		}

		for(int i = count.length - 1; i >= 0 && truckSize > 0; i--) {
			int total = Math.min(truckSize, count[i]);
			ret += i * total;
			truckSize -= total;
		}

		return ret;
	}

	public int maximumUnits1(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, Comparator.comparingInt(i -> -i[1]));
		int ret = 0;

		for(int i = 0; i < boxTypes.length && truckSize > 0; i++){
			int total = Math.min(truckSize, boxTypes[i][0]);
			ret += boxTypes[i][1] * total;
			truckSize -= total;
		}

		return ret;
	}
}
