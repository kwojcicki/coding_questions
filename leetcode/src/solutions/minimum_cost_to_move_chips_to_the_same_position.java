package solutions;

public class minimum_cost_to_move_chips_to_the_same_position {
    public int minCostToMoveChips1(int[] position) {
        
    	int left = 0;
    	int right = 0;
    	
    	for(int i: position) {
    		if(i % 2 == 0) {
    			left++;
    		} else {
    			right++;
    		}
    	}
    	
    	return Math.min(left, right);
    }
    
    public int minCostToMoveChips(int[] position) {
        
    	int left = 0;
    	
    	for(int i: position) {
    		if(i % 2 == 0) {
    			left++;
    		}
    	}
    	
    	return Math.min(left, position.length - left);
    }
}
