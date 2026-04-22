package solutions;
class minimize_hamming_distance_after_swap_operations {
    public int get(int[] f, int x){
        if(f[x] != x) f[x] = get(f, f[x]);
        return f[x];
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int ret = 0;
        
        int[] f = new int[source.length];
        for(int i = 0; i < f.length; i++) f[i] = i;

        for(int[] swap: allowedSwaps){
            int x = get(f, swap[0]);
            int y = get(f, swap[1]);
            if(x != y){
                f[x] = y;
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < f.length; i++){
            int x = get(f, i);
            if(!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(i);
        }

        for(int key: map.keySet()){
            Map<Integer, Integer> cnt = new HashMap<>();
            for(int idx: map.get(key)){
                cnt.compute(source[idx], (k,v) -> v == null ? 1 : v + 1);
                cnt.compute(target[idx], (k,v) -> v == null ? -1 : v - 1);
            }

            for(int vals: cnt.values()) ret += Math.max(vals, 0);
        }

        return ret;
    }
}
