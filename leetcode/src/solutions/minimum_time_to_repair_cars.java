package solutions;

public class minimum_time_to_repair_cars {
    public long repairCars(int[] ranks, int cars) {
long left = 1, right = Long.MAX_VALUE;
        
        while(left < right) {
        	long mid = left + (right - left) / 2;
        	
        	long tmp = 0;
        	// repair n cars in r * n ^ 2
        	for(int r: ranks) {
        		tmp += (long) Math.sqrt(mid / r);
        	}
        	
        	if(tmp >= cars) {
        		right = mid;
        	} else {
        		left = mid + 1;
        	}
        }
        
        return right;
    }
}
