package solutions;

public class set_mismatch {
	public int[] findErrorNums(int[] nums) {
		int[] ret = new int[2];

		for(int i: nums) {
			if(nums[Math.abs(i) - 1] < 0) ret[0] = Math.abs(i);
			else nums[Math.abs(i) - 1] *= -1;
		}

		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0) ret[1] = i + 1;
		}

		return ret;
	}
}
