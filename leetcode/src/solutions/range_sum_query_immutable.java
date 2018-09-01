package solutions;

public class range_sum_query_immutable {
    public range_sum_query_immutable(int[] nums) {
        sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++) {
        	sums[i] = sums[i - 1] + nums[i - 1];
        }
    }
    
    private int[] sums;
    
    public int sumRange(int i, int j) {
        return sums[j] - sums[i];
    }
}
