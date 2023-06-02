package solutions;

import java.util.HashSet;
import java.util.Set;

public class detonate_the_maximum_bombs {
	public int maximumDetonation(int[][] bombs) {
		int ret = 0;

		for(int i = 0; i < bombs.length; i++) {
			Set<Integer> seen = new HashSet<>();
			seen.add(i);
			dfs(i, bombs, seen);
			ret = Math.max(ret, seen.size());
		}

		return ret;
	}

	public void dfs(int i, int[][] bombs, Set<Integer> seen) {
		int[] bomb = bombs[i];
		for(int j = 0; j < bombs.length; j++) {
			if(!seen.contains(j) && Math.pow(bomb[0] - bombs[j][0], 2) +
					Math.pow(bomb[1] - bombs[j][1], 2) <= Math.pow(bomb[2],2)) {
				seen.add(j);
				dfs(j, bombs, seen);
			}
		}
	}
}
