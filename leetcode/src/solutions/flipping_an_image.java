package solutions;

public class flipping_an_image {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0) {
        	return A;
        }
        
        for(int r = 0; r < A.length; r++) {
        	int start = 0;
        	int end = A[r].length - 1;
        	while(start <= end) {
        		int tmp = A[r][start];
        		
        		A[r][start] = A[r][end] == 1 ? 0 : 1;
        		A[r][end] = tmp == 1 ? 0 : 1;
        		
        		start++;
        		end--;
        	}
        }
        
        return A;
    }
}
