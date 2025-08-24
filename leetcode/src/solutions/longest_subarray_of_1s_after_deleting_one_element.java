package solutions;

public class longest_subarray_of_1s_after_deleting_one_element {
	public int longestSubarray(int[] nums) {
		int ret = 0;
		int left = 0;
		int zero = 0;
		int i = 0;
		while(i < nums.length && nums[i] == 1) i++;

		if(i == nums.length) return nums.length - 1;
		zero = i;
		i++;
		for(; i < nums.length; i++) {
			if(nums[i] == 1) continue;

			//System.out.println(i + " " + left + " " + zero + " " + ret);
			ret = Math.max(i - left - 1, ret);
			left = zero + 1;
			zero = i;
		}

		ret = Math.max(i - left - 1, ret);
		return ret;
	}
}
