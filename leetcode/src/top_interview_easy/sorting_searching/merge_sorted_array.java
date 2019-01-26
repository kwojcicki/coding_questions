package top_interview_easy.sorting_searching;

public class merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] toReturn = new int[m + n];
    	int m1 = 0, n1 = 0;
    	
    	while(m1 < m && n1 < n) {
    		if(nums1[m1] < nums2[n1]) {
    			toReturn[m1 + n1] = nums1[m1];
    			m1++;
    		} else {
    			toReturn[m1 + n1] = nums2[n1];
    			n1++;
    		}
    	}
    	
    	while(m1 < m) {
    		toReturn[m1 + n1] = nums1[m1];
			m1++;
    	}
    	
    	while(n1 < n) {
    		toReturn[m1 + n1] = nums2[n1];
			n1++;
    	}
    	
    	for(int i = 0; i < nums1.length; i++) nums1[i] = toReturn[i];
    }
}
