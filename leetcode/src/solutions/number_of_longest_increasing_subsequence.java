package solutions;

public class number_of_longest_increasing_subsequence {
	public int findNumberOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		int[] inc = new int[nums.length];
		int[] ways = new int[nums.length];
		int max = 0;
		int maxWays = 0;

		inc[0] = 1;
		ways[0] = 1;

		for(int i = 1; i < nums.length; i++) {

			for(int k = i - 1; k >= 0; k--) {
				if(nums[i] > nums[k] && inc[k] >= inc[i]) {
					inc[i] = inc[k] + 1;
					ways[i] = ways[k];
				} else if(nums[i] > nums[k] && inc[k] + 1 == inc[i]) {
					ways[i] += ways[k];
				}
			}

			if(inc[i] == 0){
				inc[i] = 1;
				ways[i] = 1;
			}

		}

		// System.out.println(Arrays.toString(inc));
		// System.out.println(Arrays.toString(ways));

		for(int i = 0; i < nums.length; i++) {
			if(inc[i] > max) {
				max = inc[i];
				maxWays = ways[i];
			} else if(inc[i] == max) {
				maxWays += ways[i];
			}
		}

		return maxWays;
	}
}
