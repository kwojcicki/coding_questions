package solutions;

public class car_pooling {
    public boolean carPooling(int[][] trips, int capacity) {
        
    	int current = 0;
    	
		for(int position = 0; position <= 1000; position++) {
			
			for(int[] a: trips) {
				if(position == a[1]) {
					current += a[0];
				}
			}
			
			for(int[] a: trips) {
				if(position == a[2]) {
					current -= a[0];
				}
			}
			
			if(current > capacity) {
				return false;
			}
			
		}
    	
    	
    	return true;
    }
}
