package solutions;

public class merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int i = nums1.length - 1;
        
        while(right >= 0) {
            if(left >= 0 && nums1[left] >= nums2[right]){
                nums1[i] = nums1[left];
                left--;
            } else {
                nums1[i] = nums2[right];
                right--;
            }
            i--;
        }
    }
}
