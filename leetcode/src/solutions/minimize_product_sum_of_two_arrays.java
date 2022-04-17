package solutions;

import java.util.Arrays;

public class minimize_product_sum_of_two_arrays {
    public int minProductSum(int[] nums1, int[] nums2) {
        int ret = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        for(int i = 0; i < nums1.length; i++) {
        	ret += nums1[i] * nums2[nums2.length - 1 - i];
        }
        
        return ret;
    }
}
