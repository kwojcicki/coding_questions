package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class minimum_number_of_refueling_stops {
	
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int ret = 0;
		int pos = 0;
		int fuel = 0;
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		q.add(startFuel);
		while(!q.isEmpty()) {
			fuel += q.poll();
			if(fuel >= target) return ret;
			while(pos < stations.length && stations[pos][0] <= fuel) {
				q.add(stations[pos++][1]);
			}
			ret++;
		}
		return -1;
	}

	public int minRefuelStops1(int target, int startFuel, int[][] stations) {
		int ret = Integer.MAX_VALUE;

		List<Map<Integer, Integer>> maps = new ArrayList<>(stations.length);
		for(int[] i: stations) {
			maps.add(new HashMap<>());
		}

		Queue<int[]> q = new PriorityQueue<>((a,b) -> {
			return -Integer.compare(a[4], b[4]);
		});

		q.add(new int[] {-1, startFuel, 0, 0, 0});
		while(!q.isEmpty()) {
			int[] n = q.poll();
			int pos = n[0];
			int fuel = n[1];
			int hops = n[2];
			int position = n[3];
			// System.out.println(pos + " " + hops + " " + position);
			if(fuel + position >= target) {
				// ret = Math.min(ret, hops);
				// continue;
				return hops;
			}

			if(pos != -1 && maps.get(pos).get(hops) != fuel) continue;

			for(int i = pos + 1; i < stations.length && 
					stations[i][0] - position <= fuel; i++) {
				int newFuel = fuel - (stations[i][0] - position) + stations[i][1];
				if(!maps.get(i).containsKey(hops + 1) || 
						maps.get(i).get(hops + 1) < newFuel) {
					// System.out.println(pos + " " + hops + " " + position + " " + i + " " + newFuel);
					maps.get(i).put(hops + 1, newFuel);
					q.add(new int[] {
							i,
							newFuel,
							hops + 1,
							stations[i][0],
							stations[i][1]
					});
				}
			}
		}

		return ret == Integer.MAX_VALUE ? -1 : ret;
	}

	public static void main(String[] args) {

		Queue<int[]> q = new PriorityQueue<>((a,b) -> {
			return -Integer.compare(a[1], b[1]);
		});

		q.add(new int[] {-1, -1});
		q.add(new int[] {1, 1});

		System.out.println(Arrays.toString(q.poll()));
	}
}
