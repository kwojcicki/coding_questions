package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class maximum_performance_of_a_team {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    	int[][] emps = new int[n][2];
        for(int i = 0; i < n; i++) {
        	emps[i] = new int []{speed[i], efficiency[i]};
        }
        Arrays.sort(emps, (a,b) -> Integer.compare(b[1], a[1]));
        Queue<Integer> q = new PriorityQueue<>();
        long ret = 0, sumOfSpeed = 0;
        for(int[] e: emps) {
        	sumOfSpeed += e[0];
        	q.add(e[0]);
        	if(q.size() > k) sumOfSpeed -= q.poll();
        	ret = Math.max(ret, sumOfSpeed * e[1]);
        }
        
        return (int) (ret % (long) (Math.pow(10, 9) + 7));
    }
}
