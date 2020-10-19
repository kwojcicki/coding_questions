package solutions;

public class minimum_domino_rotations_for_equal_row {
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
