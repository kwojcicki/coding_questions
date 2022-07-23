package solutions;

import java.util.ArrayList;
import java.util.List;

public class count_of_smaller_numbers_after_self {
	int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        
        count = new int[nums.length];
        int[] indices = new int[nums.length];
        for(int i = 0; i < indices.length; i++) indices[i] = i;
        
        mergesort(nums, indices, 0, nums.length - 1);
        
        for(int i = 0; i < count.length; i++) {
        	ret.add(count[i]);
        }
        
        return ret;
    }
    
    public void mergesort(int[] nums, int[] indices, int start, int end) {
    	if(start >= end) return;
    	
    	int mid = (end - start) / 2 + start;
    	mergesort(nums, indices, start, mid);
    	mergesort(nums, indices, mid + 1, end);
    	
    	merge(nums, indices, start, end, mid);
    }
    
    public void merge(int[] nums, int[] indices, int start, int end, int mid) {
    	int left = start;
    	int right = mid + 1;
    	int[] newIndices = new int[end - start + 1];
    	int index = 0;
    	int incrementCount = 0;
    	
    	while(left <= mid && right <= end) {
    		if(nums[indices[left]] > nums[indices[right]]) {
    			newIndices[index] = indices[right];
    			incrementCount++;
    			right++;
    		} else {
    			newIndices[index] = indices[left];
    			count[indices[left]] += incrementCount;
    			left++;
    		}
    		index++;
    	}
    	
    	while(left <= mid) {
			newIndices[index] = indices[left];
			count[indices[left]] += incrementCount;
			left++;
			index++;
    	}
    	
    	while(right <= end) {
			newIndices[index] = indices[right];
			right++;
    		index++;
    	}
    	
    	for(int i = 0; i < newIndices.length; i++) {
    		indices[i + start] = newIndices[i];
    	}
    }
}
