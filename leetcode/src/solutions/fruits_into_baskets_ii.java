package solutions;

public class fruits_into_baskets_ii {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ret = 0;
        
        for(int i: fruits) {
        	boolean found = false;
        	for(int j = 0; j < baskets.length; j++) {
        		if(baskets[j] >= i) {
        			found = true;
        			baskets[j] = -baskets[j];
                    break;
        		}
        	}
        	if(!found) ret++;
        }
        
        return ret;
    }
}
