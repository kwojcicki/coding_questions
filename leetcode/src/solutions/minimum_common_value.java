package solutions;

public class minimum_common_value {
    public int getCommon(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        while(l < nums1.length && r < nums2.length){
            if(nums1[l] == nums2[r]) return nums1[l];
            if(nums1[l] > nums2[r]) r++;
            else l++;
        }
        return -1;
    }
}
