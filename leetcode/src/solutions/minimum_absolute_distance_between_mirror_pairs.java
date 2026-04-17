package solutions;

class minimum_absolute_distance_between_mirror_pairs {
    public int minMirrorPairDistance(int[] nums) {
        int ret = nums.length + 1;

        Map<Integer, Integer> m = new HashMap<>();

        for(int i = nums.length - 1; i >= 0; i--){
            int n = nums[i];
            int reversed = Integer.parseInt(new StringBuilder(Integer.toString(n)).reverse().toString());
            if(m.containsKey(reversed)) ret = Math.min(ret, m.get(reversed) - i);
            m.put(n, i);
        }

        return ret == nums.length + 1 ? -1 : ret;
    }
}

