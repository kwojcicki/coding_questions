package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class maximum_average_pass_ratio {
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		double ret = 0;

		Queue<double[]> q = new PriorityQueue<>((a,b) ->  
		Double.compare(
				(b[0] + 1) /  (b[1] + 1) - b[0] / b[1], 
				(a[0] + 1) /  (a[1] + 1) - a[0] / a[1]
				));
		for(int [] cl: classes) {
			q.add(new double[] { cl[0], cl[1] });
		}

		for(int i = 0; i < extraStudents; i++) {
			double[] n = q.poll();
			n[0]++; n[1]++;
			q.add(n);
		}

		while(!q.isEmpty()) {
			double[] n = q.poll();
			// System.out.println(Arrays.toString(n));
			ret += (n[0] / n[1]);
		}

		return (ret / classes.length);
	}
}
