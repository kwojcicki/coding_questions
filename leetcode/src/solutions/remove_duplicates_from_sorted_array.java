package solutions;

public class remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int q = 0;
        for(int i: nums) {
        	if(q <= 0 || nums[q - 1] != i) {
        		nums[q++] = i;
        	}
        }
        
        return q;
    }
}
