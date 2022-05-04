package solutions;

import java.util.HashMap;
import java.util.Map;

public class max_number_of_k_sum_pairs {
	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int ret = 0;

		for(int i: nums) {
			if(map.getOrDefault(k - i, 0) > 0) {
				map.compute(k - i, (ky, v) -> v - 1);
				ret++;
			} else {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}

		return ret;
	}
}
