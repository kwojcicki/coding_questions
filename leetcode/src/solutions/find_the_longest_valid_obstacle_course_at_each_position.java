package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class find_the_longest_valid_obstacle_course_at_each_position {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    	List<Integer> list = new ArrayList<>();
        for(int i = 0; i < obstacles.length; i++) {
        	int x = obstacles[i];
        	if(list.isEmpty() || list.get(list.size() - 1) <= x) {
        		list.add(x);
        		obstacles[i] = list.size();
        	} else {
        		int idx = Collections.binarySearch(list, x);
        		if(idx < 0) idx = -(idx) - 1;
        		while(list.get(idx) == x) idx++;
						// System.out.println(list + " " + x + " " + idx);
        		list.set(idx, x);
        		obstacles[i] = idx + 1;
        	}
        }
    	return obstacles;
    }
}
