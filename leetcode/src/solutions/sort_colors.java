package solutions;

import java.util.Arrays;

public class sort_colors {
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
		int temp = 0;
        System.out.println("b" + " " + Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++) {
        	if(i > high) {
        		return;
        	}
        	if(nums[i] == 0) {
        		temp = nums[low];
        		nums[low] = nums[mid];
        		nums[mid] = temp;
        		low++;
        		mid++;
        	} else if(nums[i] == 1) {
        		mid++;
        	} else if(nums[i] == 2) {
        		nums[i] = nums[high];
        		nums[high] = 2;
        		high--;
        		i--;
        	}
        }
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {2,0,2,1,1,0};
    	sortColors(a);
    	System.out.println(Arrays.toString(a));
    }
}
