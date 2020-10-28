package solutions;

import java.util.ArrayList;
import java.util.List;

public class summary_ranges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ret = new ArrayList<>();
		if(nums == null || nums.length == 0) return ret;

		int prev = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[prev] + (i - prev)) {
				continue;
			}

			if(prev == i - 1) {
				ret.add(Integer.toString(nums[prev]));
			} else {
				ret.add(Integer.toString(nums[prev]) + "->" + Integer.toString(nums[i - 1]));
			}

			prev = i;
		}

		int i = nums.length - 1;
		if(prev == i) {
			ret.add(Integer.toString(nums[prev]));
		} else if(prev != i){
			ret.add(Integer.toString(nums[prev]) + "->" + Integer.toString(nums[i]));
		}

		return ret;
	}
}
