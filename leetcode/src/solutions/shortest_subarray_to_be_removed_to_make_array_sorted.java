package solutions;

public class shortest_subarray_to_be_removed_to_make_array_sorted {

	public int findLengthOfShortestSubarray(int[] arr) {
		int right = arr.length - 1;
		int left = 0;
		while(right > 0 && arr[right] >= arr[right - 1]) right--;
		int ret = right;

		while(left < right) {
			if(left != 0 && arr[left] < arr[left - 1]) break;
			while(right < arr.length && arr[right] < arr[left]) right++;

			// System.out.println(right + " " + left);
			ret = Math.min(ret, right - left - 1);
			left++;
		}

		return ret;
	}
}
