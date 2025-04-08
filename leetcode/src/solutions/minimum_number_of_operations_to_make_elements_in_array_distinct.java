package solutions;

public class minimum_number_of_operations_to_make_elements_in_array_distinct {
    public int minimumOperations(int[] nums) {
        int left = 0, right = 0;
        int[] count = new int[101];
        int ret = 0;

        while(right < nums.length){
            count[nums[right]]++;
            while(count[nums[right]] > 1 && left < nums.length){
                count[nums[left++]]--;
                if(left < nums.length) count[nums[left++]]--;
                if(left < nums.length) count[nums[left++]]--;
                ret++;
            }
            right++;
        }

        return ret;
    }
}
