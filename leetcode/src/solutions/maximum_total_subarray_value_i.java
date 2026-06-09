package solutions;

class maximum_total_subarray_value_i {
    public long maxTotalValue(int[] nums, int k) {
        long min = nums[0], max = nums[0];
        for(int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return (max - min) * k;
    }
}
