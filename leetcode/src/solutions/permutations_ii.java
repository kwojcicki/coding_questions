package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class permutations_ii {
	public List<List<Integer>> permuteUnique(int[] nums) {

		Set<List<Integer>> ret = new HashSet<List<Integer>>();

		recurse(nums, 0, ret);

		return ret.stream().collect(Collectors.toList());
	}

	public static void recurse(int[] nums, int index, Set<List<Integer>> ret) {
		if(index == nums.length) {

			List<Integer> r = new ArrayList<Integer>();
			for(int a: nums) r.add(a);
			ret.add(r);
			return;
		}

		for(int i = index; i < nums.length; i++) {
			int temp = nums[i];
			nums[i] = nums[index];
			nums[index] = temp;
			recurse(nums, index+1, ret);
			temp = nums[i];
			nums[i] = nums[index];
			nums[index] = temp;
		}

	}
}
