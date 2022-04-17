package solutions;

public class remove_element {

	public int removeElement(int[] nums, int val) {
		int ret = 0;

		int start = 0;
		int end = nums.length - 1;

		while(start <= end) {
			if(nums[start] == val) {
				ret++;
				nums[start] = nums[end];
				end--;
			} else {
				start++;
			}
		}

		return nums.length - ret;
	}
}
