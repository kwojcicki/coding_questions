package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class meeting_rooms_iii {
    public int mostBooked(int n, int[][] meetings) {
    	int[] cnt = new int[n];
     	Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
     	Queue<Integer> free = new PriorityQueue<>();

     	Queue<long[]> endings = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) return Long.compare(a[0], b[0]);
     		return Long.compare(a[1], b[1]);
     	});
     	
     	for(int i = 0; i < n; i++) {
     		free.add(i);
     	}
     	int currIndex = 0;
     	
     	while(currIndex < meetings.length) {
             
             while(!endings.isEmpty() && endings.peek()[1] <= meetings[currIndex][0])
                 free.add((int)endings.poll()[0]);
             
             if(free.isEmpty()){
                 long[] end = endings.poll();
                 cnt[(int)end[0]]++;
                 endings.add(new long[] {end[0], (long) meetings[currIndex][1] - (long) meetings[currIndex][0] + (long) end[1] });
             } else {
                 int f = free.poll();
                 cnt[f]++;
                 endings.add(new long[] {f, meetings[currIndex][1] });
             }

             //System.out.println(free.size());
            // System.out.println(currIndex + " " + meetings[currIndex][0]);
     		currIndex++;
     	}
     	
         //System.out.println(Arrays.toString(cnt));

     	int max = 0;
     	for(int i = 0; i < cnt.length; i++) {
     		if(cnt[max] < cnt[i]) max = i;
     	}
        return max;
    }
}
