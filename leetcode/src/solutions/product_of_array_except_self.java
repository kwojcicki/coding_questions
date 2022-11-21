package solutions;

import java.util.Arrays;

public class product_of_array_except_self {

	public int[] productExceptSelf_fun(int[] nums) {
		int[] ret = new int[nums.length];
		int sum = Arrays.stream(nums).filter(x -> x != 0)
				.reduce((a,b) -> a * b).orElse(0);
		int zeroes = 0;
		for(int i: nums) {
			if(i == 0 && ++zeroes == 2) {
				Arrays.fill(ret, 0);
				return ret;
			}
		}

		for(int i = 0; i < ret.length; i++) {
			ret[i] = zeroes > 0 ? (nums[i] != 0 ? 0 : sum) : sum / nums[i];
		}

		return ret;
	}


	public int[] productExceptSelf(int[] nums) {
		int[] ret = new int[nums.length];
		Arrays.fill(ret, 1);

		int accum = 1;

		for(int i = 0; i < ret.length; i++) {
			ret[i] = accum;
			accum *= nums[i];
		}

		accum = 1;
		for(int i = ret.length - 1; i >= 0; i--) {
			ret[i] *= accum;
			accum *= nums[i];
		}

		return ret;
	}

	public int[] productExceptSelf1(int[] nums) {
		int[] ret = new int[nums.length];

		int left = nums[0];
		ret[0] = 1;

		for(int i = 1; i < nums.length; i++) {
			ret[i] = left;
			left *= nums[i];
		}

		int right = nums[nums.length - 1];
		for(int i = nums.length - 2; i >= 0; i--) {
			ret[i] *= right;
			right *= nums[i];
		}

		return ret;
	}
}
