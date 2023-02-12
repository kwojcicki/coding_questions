package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class minimum_fuel_cost_to_report_to_the_capital {
	long r = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length == 0) return 0;
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int[] r: roads){
            m.computeIfAbsent(r[0], (k) -> new ArrayList<>()).add(r[1]);
            m.computeIfAbsent(r[1], (k) -> new ArrayList<>()).add(r[0]);
        }
        boolean[] seen  = new boolean[roads.length + 1];
        seen[0] = true;
        for(int i: m.get(0)){
            int[] t = helper(i, m, seen, seats);
            r += t[0] + (t[1] > 0 ? 1 : 0);
        }
        return r;
    }

    public int[] helper(int i, Map<Integer, List<Integer>> m, boolean[] seen, int seats){
        // groups, curr
        int[] ret = new int[]{0, 0};
        if(seen[i]) return ret;

        seen[i] = true;

        for(int neighbor: m.get(i)){
            int[] t = helper(neighbor, m, seen, seats);
            r += t[0] + (t[1] > 0 ? 1 : 0);
            ret[0] += t[0];
            ret[1] += t[1];
        }

        ret[1]++;
        ret[0] += ret[1] / seats;
        ret[1] %= seats;

        return ret;
    }
}
