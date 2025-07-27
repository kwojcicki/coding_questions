package solutions;

public class count_hills_and_valleys_in_an_array {
	public int countHillValley(int[] nums) {
		int ret = 0;

		int prev = nums[0];
		int i = 1;
		while(i < nums.length - 1) {
			if(nums[i] == nums[i + 1]) { i++; continue; }

			// hill
			if(prev < nums[i] && nums[i] > nums[i + 1]) {
				ret++;
			} 
			// valley
			else if(prev > nums[i] && nums[i] < nums[i + 1]) {
				ret++;
			}
			prev = nums[i];
			i++;
		}

		return ret;
	}
}
