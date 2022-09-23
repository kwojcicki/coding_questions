package top_interview_easy.array;

import java.util.HashSet;
import java.util.Set;

public class contains_duplicates {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		for(int i: nums) {
			if(!seen.add(i)) return true;
		}
		return false;
	}

	public boolean containsDuplicate1(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
}
