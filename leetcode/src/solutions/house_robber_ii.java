package solutions;

public class house_robber_ii {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		return Math.max(rob_helper(nums, 0, nums.length - 2), rob_helper(nums, 1, nums.length - 1));
	}

	public int rob_helper(int[] nums, int start, int end) {
		int one = 0, two = 0;
		for(int i = start; i <= end; i++) {
			int temp = Math.max(two + nums[i], one);

			two = one;
			one = temp;
		}

		return Math.max(one, two);
	}
}
