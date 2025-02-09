package solutions;

import java.util.HashMap;
import java.util.Map;

public class count_number_of_bad_pairs {
    public long countBadPairs(int[] nums) {
        long ret = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int want = i - nums[i];
            // j - i == nums[j] - nums[i]
            // j - nums[j] == i - nums[i];
            ret = ret - sums.getOrDefault(want, 0) + i;
            sums.compute(want, (k,v) -> v == null ? 1 : v + 1);
        }

        return ret;
    }
}
