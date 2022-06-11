package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class minimum_operations_to_reduce_x_to_zero {

	public int minOperations(int[] nums, int x) {
		int target = -x;
		for(int num: nums) target += num;
		
		if(target == 0) return nums.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int sum = 0;
		map.put(sum, -1);
		int ret = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if(map.containsKey(sum - target)) {
				ret = Math.max(ret, i - map.get(sum - target));
			}
			
			map.put(sum, i);
		}
		
		return ret == 0 ? -1 : nums.length - ret;
	}

	public int minOperations1(int[] nums, int x) {
		int[] right = new int[nums.length + 1];
		int ret = Integer.MAX_VALUE;


		int accum = 0;
		for(int i = nums.length - 1; i >= 0; i--){
			accum += nums[i];
			right[nums.length - i] = accum;
		}

		accum = 0;
		for(int i = 0; i < right.length; i++) {
			if(accum > x) break;

			int index = Arrays.binarySearch(right, x - accum);
			if(i < nums.length) accum += nums[i];
			if(index < 0 || i + index >= right.length) continue;
			ret = Math.min(ret, index + i);
		}

		return ret == Integer.MAX_VALUE ? -1 : ret;
	}
}
