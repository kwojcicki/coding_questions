package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class burst_balloons {
	
	public int maxCoins(int[] nums) {
		int[] newNums = new int[nums.length + 2];
		newNums[0] = newNums[nums.length + 1] = 1;
		for(int i = 1; i < nums.length + 1; i++) {
			newNums[i] = nums[i - 1];
		}
		
		int[][] memo = new int[newNums.length][newNums.length];
		return helper(newNums, memo, 0, newNums.length - 1);
	}
	
	public int helper(int[] nums, int[][] memo, int start, int end) {
		if(start + 1 == end) return 0;
		if(memo[start][end] > 0) return memo[start][end];
		
		int ret = 0;
		
		for(int i = start + 1; i < end; i++) {
			ret = Math.max(ret, nums[i] * nums[start] * nums[end] +
					helper(nums, memo, start, i) + helper(nums, memo, i, end));
		}
		
		memo[start][end] = ret;
		return ret;
	}
	
	public Map<List<Integer>, Integer> memo = new HashMap<>();
	// times out
	public int maxCoins1(int[] nums) {
		int ret = 0;
		
		if(memo.containsKey(Arrays.stream(nums).boxed().collect(Collectors.toList()))) {
			return memo.get(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == -1) continue;

			int left = 1;
			int right = 1;

			for(int j = i - 1;j >= 0; j--) {
				if(nums[j] == -1) continue;
				left = nums[j];
				break;
			}

			for(int j = i + 1;j < nums.length; j++) {
				if(nums[j] == -1) continue;
				right = nums[j];
				break;
			}

			int tmp = nums[i];
			int toAdd = nums[i] * left * right;
			nums[i] = -1;
			ret = Math.max(ret, toAdd + maxCoins(nums));
			nums[i] = tmp;
		}

		memo.put(Arrays.stream(nums).boxed().collect(Collectors.toList()), ret);
		
		return ret;
	}
	
	// times out
	public int maxCoins2(int[] nums) {
		int ret = 0;

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == -1) continue;

			int left = 1;
			int right = 1;

			for(int j = i - 1;j >= 0; j--) {
				if(nums[j] == -1) continue;
				left = nums[j];
				break;
			}

			for(int j = i + 1;j < nums.length; j++) {
				if(nums[j] == -1) continue;
				right = nums[j];
				break;
			}

			int tmp = nums[i];
			int toAdd = nums[i] * left * right;
			nums[i] = -1;
			ret = Math.max(ret, toAdd + maxCoins(nums));
			nums[i] = tmp;
		}

		return ret;
	}
}
