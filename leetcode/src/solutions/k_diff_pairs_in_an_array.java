package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k_diff_pairs_in_an_array {
	
	public int findPairs(int[] nums, int k) {
		int count = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        System.out.println(map);
        
        for(Map.Entry<Integer, Integer> x: map.entrySet()) {
        	
        	if(k == 0 && x.getValue() > 1) {
        		count++;
        	} else if(k != 0 && map.containsKey(x.getKey() - k)) {
        		count++;
        	}
        	
        }
		
		return count;
	}
	
    public int findPairs1(int[] nums, int k) {
    	int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
        	map.get(nums[i]).add(i);
        }
        
        for(Map.Entry<Integer, List<Integer>> x: map.entrySet()) {
        	
           if(k == 0 && x.getValue().size() > 1) count++;
            
        	if(map.containsKey(x.getKey() - k) && 
        			map.get(x.getKey() - k).get(map.get(x.getKey() - k).size() - 1) > x.getValue().get(x.getValue().size() - 1)) {
        		count++;
        	}
        	
        	if(map.containsKey(x.getKey() + k) && 
        			map.get(x.getKey() + k).get(map.get(x.getKey() + k).size() - 1) > x.getValue().get(x.getValue().size() - 1)) {
        		count++;
        	}
        	
        }
        
        return count;
    }
}
