package solutions;

import java.util.Arrays;

public class reduction_operations_to_make_the_array_elements_equal {
	public int reductionOperations(int[] nums) {
		Arrays.sort(nums);

		int ret = 0;
		int sum = 0;
		int i = nums.length - 1;
		int curr = nums[i--];

		while(i >= 0) {
			sum++;
			if(curr != nums[i]) {
				ret += sum;
				curr = nums[i];
			}
			i--;
		}

		return ret;
	}
}
