package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class make_lexicographically_smallest_array_by_swapping_elements {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    	List<int[]> pairs = new ArrayList<>();
    	for(int i = 0; i < nums.length;  i++) {
            // System.out.println(nums[i] + " " + i);
    		pairs.add(new int[] { nums[i], i });
    	}
    	pairs.sort((a,b) -> a[0] - b[0]);
    	
    	List<List<int[]>> groups = new ArrayList<>();
    	groups.add(new ArrayList<>(Arrays.asList(pairs.get(0))));
    	for(int i = 1; i < nums.length; i++) {
    		if(pairs.get(i)[0] - groups.get(groups.size() - 1).get(groups.get(groups.size() - 1).size() - 1)[0] <= limit) {
    			groups.get(groups.size() - 1).add(pairs.get(i));
    		} else {
    			groups.add(new ArrayList<>(Arrays.asList(pairs.get(i))));
    		}
    	}

        // System.out.println(groups);
    	
    	for(List<int[]> group: groups) {
            // System.out.println("next group");
    		List<int[]> sortedByIndexGroup = new ArrayList<>(group);
    		sortedByIndexGroup.sort((a,b) -> a[1] - b[1]);
    		for(int i = 0; i < group.size(); i++) {
                // System.out.println("Setting: " +  sortedByIndexGroup.get(i)[1] + " to " + group.get(i)[0]);
    			nums[sortedByIndexGroup.get(i)[1]] = group.get(i)[0];
    		}
    	}
    	
    	return nums;
    }
}
