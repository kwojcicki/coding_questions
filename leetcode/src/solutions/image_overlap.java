package solutions;

public class image_overlap {
    public int largestOverlap(int[][] A, int[][] B) {
    	int max = 0;
    	
    	for(int r = -A.length + 1; r < A.length; r++) {
    		for(int c = -A[0].length + 1; c < A[0].length; c++) {
    			max = Math.max(max, shift(A, B, r, c));
    		}
    	}
    	
    	return max;
    }
    
    public int shift(int[][] A, int[][] B, int rs, int cs) {
    	int count = 0;
    	
    	for(int r = 0; r < A.length; r++) {
    		if(r + rs < 0 || r + rs >= A.length) continue;
    		for(int c = 0; c < A[r].length; c++) {
    			if(c + cs < 0 || c + cs >= A[0].length) continue;
    			if(A[r][c] == 1 && B[r + rs][c + cs] == 1) count++;
    		}
    	}
    	
    	return count;
    }
}
