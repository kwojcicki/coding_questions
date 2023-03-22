package solutions;

public class number_of_zero_filled_subarrays {
    public long zeroFilledSubarray(int[] nums) {
        long ret = 0;
        long curr = 0;

        for(int i: nums){
            if(i == 0){
                curr++;
                ret += curr;
            } else {
                curr = 0;
            }
        }

        return ret;
    }
}
