package solutions;

import java.util.Arrays;

public class sum_of_even_numbers_after_queries {
	public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
		int[] ret = new int[queries.length];

		int sum = Arrays.stream(nums)
				.filter(x -> x % 2 == 0)
				.reduce(0, (a,b) -> b + a);

		int i = 0;
		for(int[] q: queries) {
			if(nums[q[1]] % 2 == 0) {
				sum -= nums[q[1]]; 
			}
			nums[q[1]] += q[0];
			if(nums[q[1]] % 2 == 0) {
				sum += nums[q[1]];
			}
			ret[i++] = sum;
		}

		return ret;
	}
}
