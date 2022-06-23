package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class course_schedule_iii {

    public int scheduleCourse(int[][] courses) {
        int ret = 0;
        
        int days = 0;
        Arrays.sort(courses, Comparator.<int[]>comparingInt(a -> a[1]).
        		thenComparingInt(a -> a[0]));
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int[] course: courses) {
        	int newTmp = days + course[0];
        	if(newTmp <= course[1]) {
        		ret++;
        		q.add(course[0]);
        		days = newTmp;
        		continue;
        	}
        	
        	if(!q.isEmpty() && course[0] < q.peek() && days + course[0] - q.peek() <= course[1]) {
                days = days + course[0] - q.poll();
        		q.add(course[0]);
        		continue;
        	}
        }
        
        return ret;
    }
}
