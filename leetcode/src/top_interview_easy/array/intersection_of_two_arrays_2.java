package top_interview_easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class intersection_of_two_arrays_2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        
        Map<Integer, Integer> nums1map = new HashMap<>();
        Arrays.stream(nums1).forEach(i -> {
        	if(nums1map.containsKey(i)) {
        		nums1map.put(i, nums1map.get(i) + 1);
        	} else {
        		nums1map.put(i, 1);
        	}
        });
        Map<Integer, Integer> nums2map = new HashMap<>();
        Arrays.stream(nums2).forEach(i -> {
        	if(nums2map.containsKey(i)) {
        		nums2map.put(i, nums2map.get(i) + 1);
        	} else {
        		nums2map.put(i, 1);
        	}
        });
        
        nums1map.forEach( (key,value) -> {
        	if(nums2map.containsKey(key)) {
        		toReturn.addAll(Collections.nCopies(Math.min(nums2map.get(key),  nums1map.get(key)), key));
        	}
        });
        
        return toReturn.stream().mapToInt(i->i).toArray();
    }
	
    public static void main(String[] args) {
    	intersection_of_two_arrays_2 s = new intersection_of_two_arrays_2();
    	System.out.println(Arrays.toString(s.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
    	
    	System.out.println(Arrays.toString(s.intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
    
    }
}
