package solutions;

import java.util.Arrays;

public class boats_to_save_people {

	public int numRescueBoat(int[] people, int limit) {
		int[] weights = new int[limit + 1];
		for(int i: people) weights[i]++;
		
		int start = 0;
		int end = limit;
		int ret = 0;
		
		while(end >= start) {
			while(start <= end && weights[start] <= 0) start++;
			while(start <= end && weights[end] <= 0) end--;
			
			if(weights[start] <= 0 && weights[end] <= 0) break;
			// System.out.println(Arrays.toString(weights));
			if(start + end <= limit) {
				weights[start]--;
			}
			weights[end]--;
			ret++;
		}
		
		return ret;
	}
	
	public int numRescueBoats1(int[] people, int limit) {
		int ret = 0;
		Arrays.sort(people);

		int start = 0;
		int end = people.length - 1;

		while(end > start) {
			if(people[end] + people[start] <= limit) {
				start++;
			}

			end--;
			ret++;
		}

		return end == start ? ret + 1 : ret;
	}

}
