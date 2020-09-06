package solutions;

public class image_overlap {
    public int largestOverlap(int[][] A, int[][] B) {
    	int max = 0;
    	
    	for(int r = 0; r < A.length; r++) {
    		for(int c = 0; c < A[r].length; c++) {
    			max = Math.max(max, shift(A, B, r, c));
    			max = Math.max(max, shift(B, A, r, c));
    		}
    	}
    	
    	return max;
    }
    
    public int shift(int[][] A, int[][] B, int rs, int cs) {
    	int count = 0;
    	
    	int bRow = 0;
    	for(int r = rs; r < A.length; r++) {
    		int bCol = 0;
    		for(int c = cs; c < A[r].length; c++) {
    			if(A[r][c] == 1 && B[bRow][bCol] == A[r][c]) {
    				count++;
    			}
    			bCol++;
    		}
    		bRow++;
    	}
    	
    	return count;
    }
}
