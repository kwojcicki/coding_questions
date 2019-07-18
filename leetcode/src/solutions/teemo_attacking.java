package solutions;

public class teemo_attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = timeSeries.length > 0 ? duration : 0;
        
        for(int i = 0; i < timeSeries.length - 1; i++) {
        	if(timeSeries[i + 1] - timeSeries[i] > duration) {
        		ret += duration;
        	} else {
        		ret += timeSeries[i + 1] - timeSeries[i];
        	}
        }
        
        return ret;
    }
}
