package solutions;

import java.util.Arrays;

public class meeting_rooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            
            return Integer.compare(a[1], b[1]);
        });
          
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1]) return false;
        }
        
        return true;
    }
}
