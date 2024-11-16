package solutions;

public class find_the_power_of_k_size_subarrays_i {
	public int[] resultsArray(int[] nums, int k) {
		if(k == 1) return nums;

		int[] ret = new int[nums.length - k + 1];
		int l = 0, r = 0;

		while(r < nums.length && l < ret.length) {
			// System.out.println(l + " " + r);
			if(nums[l] + r - l == nums[r]) r++;
			else {
				ret[l] = -1;
				l++; r = l + 1;
			}
			if(r - l == k) {
				ret[l] = nums[r - 1];
				l++;
			}
		}

		return ret;
	}
}
