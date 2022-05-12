package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class permutations_ii {
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] seen = new boolean[nums.length];
        
        helper(seen, new ArrayList<>(nums.length), nums, ret);
        return ret;
    }
	
	public void helper(boolean[] seen, List<Integer> curr, int[] nums, List<List<Integer>> ret) {
		if(curr.size() == nums.length) {
			ret.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(seen[i] || (i > 0 && nums[i] == nums[i - 1] && seen[i - 1])) continue;
			seen[i] = true;
			curr.add(nums[i]);
			helper(seen, curr, nums, ret);
			curr.remove(curr.size() - 1);
			seen[i] = false;
		}
	}
	
	public List<List<Integer>> permuteUnique1(int[] nums) {

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
