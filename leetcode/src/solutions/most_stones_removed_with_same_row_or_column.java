package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class most_stones_removed_with_same_row_or_column {
	
	Map<Integer, Integer> f = new HashMap<>();
	int islands = 0;
    public int removeStones(int[][] stones) {
        for(int[] s: stones) {
        	union(s[0], s[1] + 10000);
        }
    	return stones.length - islands;
    }
    
    public int find(int x) {
    	if(!f.containsKey(x)) {
    		f.put(x, x);
    		islands++;
    		return x;
    	} else if(x != f.get(x)) {
    		return find(f.get(x));
    	}
    	
    	return x;
    }
    
    public void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	
    	if(x != y) {
    		f.put(y, x);
            islands--;
    	}
    }
    
    public int removeStones1(int[][] stones) {
        int count = 0;
        
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        
        for(int[] stone: stones) {
        	rows.putIfAbsent(stone[0], new HashSet<>());
        	cols.putIfAbsent(stone[1], new HashSet<>());
        	
        	rows.get(stone[0]).add(stone[1]);
        	cols.get(stone[1]).add(stone[0]);
        }
        
        for(int[] stone: stones) {
        	if(rows.containsKey(stone[0]) && rows.get(stone[0]).contains(stone[1])) {
        		count++;
        		dfs(stone, rows, cols);
        	}
        }
        
        return stones.length - count;
    }

	private void dfs(int[] stone, Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> cols) {
		Set<Integer> r = rows.remove(stone[0]);
		Set<Integer> c = cols.remove(stone[1]);
		
		if(r != null) {
			for(Integer column: r) {
				if(column == stone[1]) continue;
				dfs(new int[] {stone[0], column}, rows, cols);
			}
		}
		
		if(c != null) {
			for(Integer row: c) {
				if(row == stone[0]) continue;
				dfs(new int[] {row, stone[1]}, rows, cols);
			}
		}
	}
}
