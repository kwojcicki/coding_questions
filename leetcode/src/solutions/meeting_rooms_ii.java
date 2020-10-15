package solutions;

import java.util.Arrays;

public class meeting_rooms_ii {
    public int minMeetingRooms(int[][] intervals) {
        Integer[] start = Arrays.stream(intervals).map(i -> i[0]).toArray(Integer[]::new);
        Integer[] end = Arrays.stream(intervals).map(i -> i[1]).toArray(Integer[]::new);
        
        Arrays.sort(start);
        Arrays.sort(end, (a, b) -> Integer.compare(b, a));
        
       int rooms = 0;
       int endPtr = 0;
       
       for(int i = 0; i < intervals.length; i++) {
    	   if(intervals[i][0] < intervals[endPtr][1]) {
    		   rooms++;
    	   } else {
    		   endPtr++;
    	   }
       }
       
       return rooms; 
    }
}
