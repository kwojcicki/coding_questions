package top_interview_easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class two_sum {
	
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
        	map.put(target - nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i]) && map.get(nums[i]) != i) {
        		return new int[] { map.get(nums[i]), i};
        	}
        }
        
        return null;
    }
	
    public static void main(String[] args) {
    	two_sum s = new two_sum();
    	int[] a = new int[] {0,1,0,3,12};
    	
    	System.out.println(Arrays.toString(s.twoSum(new int[] { 2, 7, 11, 15}, 9)));
    }
}
