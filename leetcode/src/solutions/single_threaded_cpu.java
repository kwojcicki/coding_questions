package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class single_threaded_cpu {
    public int[] getOrder(int[][] t1) {
    	int[][] tasks = new int[t1.length][3];
    	for(int i = 0; i < tasks.length; i++) {
    		tasks[i] = new int[] { t1[i][0], t1[i][1], i };
    	}
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> q = new PriorityQueue<>((a,b) -> {
        	if(a[1] == b[1]) return Integer.compare(a[2], b[2]);
        	
        	return Integer.compare(a[1], b[1]);
        });
        int i = 0;
        int[] ret = new int[tasks.length];
        
        for(; i < tasks.length; i++) {
        	if(tasks[i][0] != tasks[0][0]) {
        		break;
        	}
        	q.add(tasks[i]);
        }
        
        int r = 0;
        int t = tasks[0][0];
        while(!q.isEmpty()) {
        	int[] n = q.poll();
        	ret[r++] = n[2];
        	t += n[1];
        	for(; i < tasks.length; i++) {
        		if(tasks[i][0] > t ) break;
        		q.add(tasks[i]);
        	}
            if(q.isEmpty() && i < tasks.length) { 
                t = tasks[i][0];
                q.add(tasks[i++]);
                while(i < tasks.length && tasks[i][0] == q.peek()[0]) 
                    q.add(tasks[i++]);
            }
        }
        
        return ret;
    }
}
