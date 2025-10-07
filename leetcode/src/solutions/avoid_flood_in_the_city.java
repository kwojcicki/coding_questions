package solutions;

public class avoid_flood_in_the_city {
    public int[] avoidFlood(int[] rains) {
        int[] ret = new int[rains.length];
        TreeSet<Integer> zeros = new TreeSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        Arrays.fill(ret, -1);

        for(int i = 0; i < rains.length; i++){
            int r = rains[i];
            if(r == 0) {
                zeros.add(i);
                continue;
            } else if(seen.containsKey(r)){
                int idx = seen.get(r);
                Integer zero = zeros.ceiling(idx);
                if(zero == null) return new int[]{};
                ret[zero] = r;
                zeros.remove(zero);
            }
            seen.put(r, i);
        }
        
        for(int i: zeros) ret[i] = 1;
        return ret; 
    }
}
