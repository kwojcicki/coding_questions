package solutions;

public class set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        
        for(int r = 0; r < matrix.length; r++) {
        	if(matrix[r][0] == 0) firstColumnZero = true;
        }
        
        for(int c = 0; c < matrix[0].length; c++) {
        	if(matrix[0][c] == 0) firstRowZero = true;
        }
        
        for(int r = 1; r < matrix.length; r++) {
        	for(int c = 1; c < matrix[r].length; c++) {
        		if(matrix[r][c] == 0) {
        			matrix[r][0] = 0;
        			matrix[0][c] = 0;
        		}
        	}
        }
        
        
        for(int c = 1; c < matrix[0].length; c++) {
        	if(matrix[0][c] == 0) {
        		
        		for(int r = 1; r < matrix.length; r++) {
        			matrix[r][c] = 0;
        		}
        		
        	}
        }
        
        for(int r = 1; r < matrix.length; r++) {
        	if(matrix[r][0] == 0) {
        		
        		for(int c = 1; c < matrix[0].length; c++) {
        			matrix[r][c] = 0;
        		}
        		
        	}
        }
        
        if(firstRowZero) {
            
            for(int c = 0; c < matrix[0].length; c++) {
            	matrix[0][c] = 0;
            }
        }
        
        if(firstColumnZero) {
        	for(int r = 0; r < matrix.length; r++) {
            	matrix[r][0] = 0;
            }
        }

    }
}
