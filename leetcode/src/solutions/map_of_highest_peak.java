package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class map_of_highest_peak {
	public int[][] highestPeak(int[][] isWater) {

		Queue<int[]> q = new LinkedList<>();

		for(int i = 0; i < isWater.length; i++) {
			for(int j = 0; j < isWater[0].length; j++) {
				if(isWater[i][j] == 1) {
					q.add(new int[] {i,j});
					isWater[i][j] = 0;
				} else {
					isWater[i][j] = -1;
				}
			}
		}

		int set = 0;
		while(!q.isEmpty()) {
			for(int i = q.size(); i > 0; i--) {
				int[] n = q.poll();
				if(isWater[n[0]][n[1]] != -1) {
					break;
				}
				isWater[n[0]][n[1]] = set;
				if(n[0] + 1 < isWater.length) q.add(new int[] { n[0] + 1, n[1]});
				if(n[0] - 1 >= 0) q.add(new int[] { n[0] - 1, n[1]});
				if(n[1] + 1 < isWater.length) q.add(new int[] { n[0], n[1] + 1});
				if(n[1] - 1 >= 0) q.add(new int[] { n[0], n[1] - 1});
			}
			set++;
		}

		return isWater;
	}
}
