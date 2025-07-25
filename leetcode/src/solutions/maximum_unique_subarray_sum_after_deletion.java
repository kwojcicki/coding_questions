package solutions;

public class maximum_unique_subarray_sum_after_deletion {
    public int maxSum(int[] nums) {
        int ret = 0;
        int max = -200;
        boolean[] seen = new boolean[101];

        for(int i: nums){
            max = Math.max(max, i);
            if(i <= 0 || seen[i]) continue;
            seen[i] = true;
            ret += i;
        }

        return ret > 0 ? ret : max;
    }
}
