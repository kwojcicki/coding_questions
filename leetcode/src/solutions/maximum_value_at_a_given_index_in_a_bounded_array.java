package solutions;

public class maximum_value_at_a_given_index_in_a_bounded_array {
	public int maxValue(int n, int index, int maxSum) {
		int left = 0;
		int right = maxSum;
		maxSum -= n;

		while(left < right){
			int mid = (left + right + 1) / 2;
			long sum = 0;

			int left1 = Math.max(mid - index, 0);
			sum = (long)(mid + left1) * (mid - left1 + 1) / 2;

			int right1 = Math.max(mid - ((n - 1) - index), 0);
			sum += (long)(mid + right1) * (mid - right1 + 1) / 2;
			sum -= mid;

			if(sum <= maxSum){
				left = mid;
			} else {
				right = mid - 1;
			}

		}

		// System.out.println(low + " " + high);

		return left + 1;
	}
}
