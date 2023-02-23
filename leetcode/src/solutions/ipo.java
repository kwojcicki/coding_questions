package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ipo {
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int ret = w;

		int[][] jobs = new int[profits.length][2];
		for(int i = 0; i < profits.length; i++) {
			jobs[i][0] = profits[i];
			jobs[i][1] = capital[i];
		}

		Arrays.sort(jobs, (a,b) -> {
			if(a[1] == b[1]) return Integer.compare(b[0], a[0]);
			return Integer.compare(a[1], b[1]);
		});

		Queue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		int i = 0;
		p.add(0);
		while(!p.isEmpty() && k-- >= 0) {
			ret += p.poll();
			while(i < jobs.length && jobs[i][1] <= ret) p.add(jobs[i++][0]);
		}

		return ret;
	}
}
