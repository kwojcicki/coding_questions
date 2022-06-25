package solutions;

public class non_decreasing_array {
	public boolean checkPossibility(int[] nums) {
		boolean switched = false;

		for(int i = 1; i < nums.length; i++) {
			if(nums[i] >= nums[i - 1]) continue;
			if(switched) return false;
			switched = true;

			if(i - 2 < 0 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];
			else nums[i] = nums[i - 1];
		}

		return true;
	}
}
