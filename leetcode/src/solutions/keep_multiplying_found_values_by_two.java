package solutions;

public class keep_multiplying_found_values_by_two {
    public int findFinalValue(int[] nums, int original) {
        int ret = original;
        Set<Integer> s = new HashSet<>();
        for(int i: nums) s.add(i);
        while(s.contains(ret)) ret *= 2;
        return ret;
    }
}
