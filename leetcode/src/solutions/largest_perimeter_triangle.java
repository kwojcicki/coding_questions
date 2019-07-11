package solutions;

import java.util.Arrays;

public class largest_perimeter_triangle {
    public int largestPerimeter(int[] A) {
    	int ret = 0;
    	
    	Arrays.sort(A);
    	
    	for(int i = A.length - 1; i > 1; i--) {
			if(A[i] < A[i - 1] + A[i - 2]) ret = Math.max(ret, A[i] + A[i - 1] + A[i - 2]);
    	}
    
    	
    	return ret;
    }
}
