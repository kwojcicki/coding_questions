package solutions;

public class make_sum_divisible_by_p {
    public int minSubarray(int[] nums, int p) {
        int ret = 1_000_000_001;
        Map<Integer, Integer>  map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i: nums) sum = (sum + i) % p;
        int tar = sum % p;
        if(tar == 0) return 0;
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = (sum + nums[i]) % p;
            Integer lastSeen = map.get((sum - tar + p) % p);
            if(lastSeen != null) {
                ret = Math.min(ret, i - lastSeen);
            }
            map.put(sum, i);
        }

        return ret == nums.length ? -1 : ret;
    }
}
