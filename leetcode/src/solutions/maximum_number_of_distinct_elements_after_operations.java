package solutions;

public class maximum_number_of_distinct_elements_after_operations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        nums[0] -= k;
        int ret = 1;

        for(int i = 1; i < nums.length; i++){
            int prev = nums[i - 1];
            int newVal = prev + 1;

            if(Math.abs(newVal - nums[i]) > k){
                if(newVal > nums[i]){
                    nums[i] += k;
                } else {
                    nums[i] -= k;
                    ret++;
                }
            } else {
                nums[i] = newVal;
                ret++;
            }
        }

// System.out.println(Arrays.toString(nums));
        return ret;
    }
}
