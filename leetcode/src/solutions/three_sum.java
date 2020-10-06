package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class three_sum {

	public static void main(String[] args) {
		new three_sum().threeSum(new int[] {-1,0,1,2,-1,-4});
		System.out.println("--");
		new three_sum().threeSum(new int[] {-2, 0,0,0,1,1,1,1,1});
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();

		Arrays.sort(nums);

		for(int i = 0; i < nums.length; i++) {
			if(i == 0 || nums[i - 1] != nums[i]) {
				System.out.println("i: " + i + "");
				three(nums, ret, i);
			}
		}

		return ret;
	}

	public void three(int[] nums, List<List<Integer>> ret, int i) {
		int low = i + 1;
		int high = nums.length - 1;
		while(low < high) {
			int sum = nums[i] + nums[low] + nums[high]; 
			if(sum < 0) {
				System.out.println("high");
				low++;
			} else if (sum > 0) {
				System.out.println("low");
				high--;
			} else {
				System.out.println("added");
				ret.add(Arrays.asList(new Integer[] {nums[i], nums[low], nums[high]}));
				low++;
				high--;
				while(low < high && nums[low] == nums[low - 1]) {
					System.out.println("middle");
					low++;
				}
			}
		}
	}

	public List<List<Integer>> threeSum1(int[] nums) {
		Set<List<Integer>> ret = new HashSet<>();

		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				for(int k = j + 1; k < nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						Collections.sort(temp);
						ret.add(temp);
					}
				}
			}
		}

		return ret.stream().collect(Collectors.toList());
	}
}
