package solutions;

public class sqrtx {
	
    public int mySqrt1(int x) {
        for(int i = 1; i < x / 2 + 2; i++){
            if( i * i > x || i * i < 0){
                return i - 1;
            }
        }
        return 1;
    }
    
    public static int mySqrt(int x) {
    	if(x == 0) return 0;
    	int start = 1;
    	int end = x;
    	
    	while(start <= end) {
    		
    		int mid = start + (end - start) / 2;
    		
    		if( mid > x / mid && (mid - 1) <= x / (mid - 1)) {
    			return mid - 1;
    		} else if(mid > x / mid) {
    			end = mid;
    		} else {
    			start = mid + 1;
    		}
    	}
    	
    	return 1;
    }
    
}
