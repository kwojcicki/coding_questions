package top_interview_easy.array;

public class contains_duplicates {
    public boolean containsDuplicate(int[] nums) {
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
