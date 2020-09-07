package solutions;

import java.util.Arrays;

public class rotate_image {
    public static void rotate(int[][] matrix) {

    	for(int r = 0; r < matrix.length / 2 ; r++) {
    		int first = r;
    		int last = matrix.length - 1 - r;
    		
    		for(int c = r; c < last; c++) {
    			
    			int offset = c - r; 
    			
    			int temp = matrix[first][c];
    			
    			matrix[first][c] = matrix[last - offset][first];
    			
    			matrix[last - offset][first] = matrix[last][last - offset];
    			
    			matrix[last][last - offset] = matrix[c][last];
    			
    			matrix[c][last] = temp;
    			
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[][] A = new int[][] {
    		{1,2,3},
    		{4,5,6},
    		{7,8,9}
    	};

    	for(int[] a: A) {
    		System.out.println(Arrays.toString(a));
    	}
    	
    	System.out.println();
    	rotate(A);
    	
    	for(int[] a: A) {
    		System.out.println(Arrays.toString(a));
    	}
    }
}
