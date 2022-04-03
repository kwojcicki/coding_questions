package solutions;

public class next_permutation {

	public void nextPermutation(int[] nums) {
		int k = nums.length - 2;
		for(;k >= 0; k--) {
			if(nums[k] < nums[k + 1]) {
				break;
			}
		}

		if(k < 0) {
			int start = 0, end = nums.length - 1;
			while(start < end) {
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
				start++;
				end--;
			}
			return;
		}

		int start = nums.length - 1;
		for(; start > k; start--) {
			if(nums[start] > nums[k]) {
				break;
			}
		}

		int tmp = nums[start];
		nums[start] = nums[k];
		nums[k] = tmp;

		start = k + 1;
		int end = nums.length - 1;

		while(start < end) {
			tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
