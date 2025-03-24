package solutions;

import java.util.Arrays;

public class count_days_without_meetings {
    public int countDays(int days, int[][] meetings) {
int ret = 0;
        
        Arrays.sort(meetings, (a,b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        
        int day = 1;
        for(int[] meeting: meetings) {
        	if(day < meeting[0]) ret += meeting[0] - day;
        	day = Math.max(day, meeting[1] + 1);
        	// System.out.println(Arrays.toString(meeting) + " " + ret + " " + day);
        }
        
        return ret + (day <= days ? days - day + 1 : 0);
    }
}
