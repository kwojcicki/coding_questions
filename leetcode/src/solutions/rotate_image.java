package solutions;

import java.util.Arrays;

public class rotate_image {
	
	public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length / 2; i++){
            for(int j = i; j < matrix.length - 1 - i; j++){
                int tmp = matrix[i][j];
                int len = matrix.length - 1;
                matrix[i][j] = matrix[len - j][i];
                matrix[len - j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len  - i] = tmp;
            }
        }
    }
	
    public static void rotate1(int[][] matrix) {

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
    	rotate1(A);
    	
    	for(int[] a: A) {
    		System.out.println(Arrays.toString(a));
    	}
    }
}
