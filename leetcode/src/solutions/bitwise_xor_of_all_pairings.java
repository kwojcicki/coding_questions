package solutions;

public class bitwise_xor_of_all_pairings {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums1.length % 2 == 0 && nums2.length % 2 == 0) return 0;
        
        int ret = 0;
        if(nums2.length % 2 == 1) for(int i: nums1) ret ^= i;
        if(nums1.length % 2 == 1) for(int i: nums2) ret ^= i;
        
        return ret;
    }
}
