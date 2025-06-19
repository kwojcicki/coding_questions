package solutions;

import java.util.Arrays;

public class partition_array_such_that_maximum_difference_is_k {
    public int partitionArray(int[] nums, int k) {
        int ret = 1;
        Arrays.sort(nums);
        int segmentStart = nums[0];
        for(int i: nums){
            if(i - segmentStart <= k) continue;
            else {
                ret++;
                segmentStart = i;
            }
        }
        return ret;
    }
}
