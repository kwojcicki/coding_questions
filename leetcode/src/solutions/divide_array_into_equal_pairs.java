package solutions;

public class divide_array_into_equal_pairs {
    public boolean divideArray(int[] nums) {
        int[] cnt = new int[501];
        for(int i: nums) cnt[i]++;
        for(int i: cnt) if(i % 2 != 0) return false;
        return true;
    }
}
