package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class prison_cells_after_n_days {
    public int[] prisonAfterNDays(int[] cells, int n) {
    	Map<String, Integer> map = new HashMap<>();
    	
    	while(n > 0) {
    		map.put(Arrays.toString(cells), n);
            n--;
    		int[] c = new int[8];
    		for(int i = 1; i < 7; i++) {
    			c[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
    		}
    		
    		cells = c;
    		
    		if(map.containsKey(Arrays.toString(cells))) {
    			n = n % (map.get(Arrays.toString(cells)) - n);
    		}
    	}
    	
    	return cells;
    }
    
    public static void main(String[] args) {
    	new prison_cells_after_n_days().prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 1);
    }
}
