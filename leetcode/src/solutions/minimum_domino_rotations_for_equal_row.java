package solutions;

public class minimum_domino_rotations_for_equal_row {
	
    public int minDominoRotations1(int[] tops, int[] bottoms) {
        int majT = majority(tops);
        int majB = majority(bottoms);
        
        int ret1 = 0;
        int ret2 = 0;
        
        for(int i = 0; i < tops.length; i++) {
        	if(tops[i] != majT && bottoms[i] != majT) {
                ret1 = Integer.MAX_VALUE;
                break;
        	} else if(bottoms[i] != majT) {
                ret1++;
        	}
        }
        
       for(int i = 0; i < tops.length; i++) {
        	if(tops[i] != majB && bottoms[i] != majB) {
                ret2 = Integer.MAX_VALUE;
                break;
        	} else if(tops[i] != majB) {
                ret2++;
        	}
        }
        
        return Math.min(ret1, ret2) == Integer.MAX_VALUE ? -1 : Math.min(ret1, ret2);
    }
	
	public int majority(int[] a) {
		int count = 0;
		int ret = 0;
		
		for(int i: a) {
			if(i == ret) {
				count += 1;
			} else {
				count--;
				ret = count == 0 ? i : ret;
				count = Math.max(count, 1);
			}
		}
		
		return ret;
	}
	
    public int minDominoRotations(int[] A, int[] B) {
    	int min = Math.min(helper(A, A[0], B), helper(A, B[0], B));
    	min = Math.min(min, helper(B, B[0], A));
    	min = Math.min(min, helper(B,A[0], A));
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    public int helper(int[] A, int value, int[] B) {
    	int swaps = 0;
    	
    	for(int i = 0; i < A.length; i++) {
    		if(A[i] != value) {
    			if(B[i] == value) {
    				swaps++;
    			} else {
    				return Integer.MAX_VALUE;
    			}
    		}
    	}
    	
    	return swaps;
    }
}
