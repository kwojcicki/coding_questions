package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class find_players_with_zero_or_one_losses {
    public List<List<Integer>> findWinners(int[][] matches) {
    	List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> loses = new TreeMap<Integer, Integer>();
        
        for(int[] m: matches) {
        	loses.putIfAbsent(m[0], 0);
        	loses.putIfAbsent(m[1], 0);
        	
        	loses.compute(m[1], (k,v) -> v + 1);
        }
        
        List<Integer> never = new ArrayList<>();
        List<Integer> once = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> p: loses.entrySet()) {
        	if(p.getValue() == 0) {
        		never.add(p.getKey());
        	} else if(p.getValue() == 1) {
        		once.add(p.getKey());
        	}
        }
        
        ret.add(never);
        ret.add(once);
        
        return ret;
    }
}
