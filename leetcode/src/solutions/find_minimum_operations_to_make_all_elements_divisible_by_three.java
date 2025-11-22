package solutions;

public class find_minimum_operations_to_make_all_elements_divisible_by_three {
    public int minimumOperations(int[] nums) {
        int ret = 0;

        for(int i: nums){
            ret += Math.min(i % 3, 3 - (i % 3));
        }

        return ret;
    }
}
