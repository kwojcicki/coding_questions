package solutions;
class maximum_distance_between_a_pair_of_values {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ret = 0;
        int l = 0, r = 0;

        while(l < nums1.length && r < nums2.length){
            if(l > r) { r++; continue; }
            if(nums1[l] <= nums2[r]) {
                ret = Math.max(r - l, ret);
                r++;
            } else {
                l++;
            }
        }
        return ret;
    }
}
