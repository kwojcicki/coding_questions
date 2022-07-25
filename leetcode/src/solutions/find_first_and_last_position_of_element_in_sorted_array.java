package solutions;

public class find_first_and_last_position_of_element_in_sorted_array {

	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) return new int[] { -1, -1};
		if(nums[0] == target && nums[nums.length - 1] == target) return new int[] { 0, nums.length - 1};

		int[] ret = new int[] { -1, -1};

		int start = 0, end = nums.length - 1, mid = -1;
		while(start < end) {
			mid = (end - start) / 2 + start;
			if(nums[mid] >= target) end = mid;
			else start = mid + 1;
		}

		if(nums[start] != target) return ret;
		ret[0] = start;

		end = nums.length - 1; mid = -1;
		while(start < end) {
			mid = (end - start) / 2 + start + 1;
			if(nums[mid] > target) end = mid - 1;
			else start = mid;
		}

		ret[1] = end;

		return ret;
	}

	public int[] searchRange1(int[] nums, int target) {
		if(nums == null || nums.length == 0) return new int[] { -1, -1};
		if(nums.length == 1 && nums[0] == target) return new int[]{ 0, 0 };

		int[] ret = new int[] { -1, -1};
		int start = 0, end = nums.length - 1;
		while(start < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] < target) start = mid + 1;
			else end = mid;
		}

		if(nums[start] != target) return ret;
		ret[0] = start;

		end = nums.length - 1;
		while(start < end) {
			int mid = start + (end - start) / 2 + 1;
			if(nums[mid] > target) end = mid - 1;
			else start = mid;
		}

		ret[1] = end;

		return ret;
	}

}
