package solutions;

public class guess_number_higher_or_lower {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
        	int mid = (high - low) / 2 + low;
        	int g = guess(mid);
        	if(g == 0) return mid;
        	else if(g < 0) {
        		high = mid - 1;
        	} else if(g > 0) {
        		low = mid + 1;
        	}
        }
        
        return -1;
    }
    
    private int guess(int n) {
    	return -1;
    }
}
