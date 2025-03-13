package solutions;

public class zero_array_transformation_i {
	public boolean isZeroArray(int[] nums, int[][] queries) {
		int[] cnt = new int[nums.length + 1];

		for(int[] q: queries) {
			cnt[q[0]]++;
			cnt[q[1] + 1]--;
		}

		int line = 0;
		for(int i = 0; i < nums.length; i++) {
			line += cnt[i];
			if(nums[i] > line) return false;
		}

		return true;
	}
}
