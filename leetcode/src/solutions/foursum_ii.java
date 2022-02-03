package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class foursum_ii {
	public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();

		Arrays.stream(nums1).forEach(i -> Arrays.stream(nums2).forEach(j -> map.compute(i + j, 
				(k, v) -> v == null ? 1 : v + 1)));

		return Arrays.stream(nums3).map(i -> Arrays.stream(nums4).map(j -> map.getOrDefault(-(i + j), 0)).sum()).sum();
	}
	
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i: nums1)
			for(int j: nums2)
				map.compute(i + j, (k, v) -> v == null ? 1 : v + 1);
		
		int ret = 0;
		for(int i: nums3)
			for(int j: nums4)
				ret += map.getOrDefault(-(i + j), 0);
				
		return ret;
	}
}
