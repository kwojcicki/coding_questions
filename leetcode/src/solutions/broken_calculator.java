package solutions;

public class broken_calculator {
    public int brokenCalc(int startValue, int target) {
        int ret = 0;
    	while(target > startValue) {
    		if(target % 2 == 0 && target > startValue) {
    			target /= 2;
    		} else {
    			target++;
    		}
    		ret++;
    	}
    	
    	return ret + startValue - target;
    }
}
