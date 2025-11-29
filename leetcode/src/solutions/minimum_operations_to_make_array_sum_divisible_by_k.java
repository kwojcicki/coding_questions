package solutions;

public class minimum_operations_to_make_array_sum_divisible_by_k {
    public int minOperations(int[] nums, int k) {
        int sum = 0;

        for(int i: nums) sum += i;

        return sum % k;
    }
}
