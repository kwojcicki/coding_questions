package solutions;

import java.util.HashMap;
import java.util.Map;

public class contiguous_array {
	
    public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int ret = 0;
		int ones = 0;
		int zeroes = 0;

        map.put(0, -1);
        
		for(int i = 0; i < nums.length; i++) {
            ones += nums[i] == 1 ? 1 : 0;
			zeroes += nums[i] == 0 ? 1 : 0;

			int tmp = ones - zeroes;
            ret = Math.max(ret, i - map.getOrDefault(tmp, i + 1));
            map.putIfAbsent(tmp, i);
		}
		
		return ret;
    }
	
	public int findMaxLength1(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int ret = 0;
		int ones = 0;
		int zeroes = 0;

        map.put(0, -1);
        
		for(int i = 0; i < nums.length; i++) {
            ones += nums[i] == 1 ? 1 : 0;
			zeroes += nums[i] == 0 ? 1 : 0;

			// 2 0
			int tmp = ones - zeroes;
			if(ones > zeroes) {
				ret = Math.max(ret, i - map.getOrDefault(tmp, i + 1));
				map.putIfAbsent(tmp, i);
			} else if(zeroes > ones) {
				ret = Math.max(ret, i - map.getOrDefault(tmp, i + 1));
				map.putIfAbsent(tmp, i);
			} else {
				ret = Math.max(ret, i + 1);
			}
		}
		
		return ret;
	}
}
