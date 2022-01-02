package solutions;

import java.util.HashMap;
import java.util.Map;

public class pairs_of_songs_with_total_durations_divisible_by_60 {
	public int numPairsDivisibleBy601(int[] time) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int i: time) {
			count += map.getOrDefault((600 - i) % 60, 0);
			map.merge(i%60, 1, (prev,value) -> prev + 1);
		}

		return count;
	}
	
	public int numPairsDivisibleBy60(int[] time) {
		int ret = 0;
		int[] count = new int[60];
		
		for(int i: time) {
			ret += count[(600 - i) % 60];
			count[i%60]++;
		}
		
		return ret;
	}
}
