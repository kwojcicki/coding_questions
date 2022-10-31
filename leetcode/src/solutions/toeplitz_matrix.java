package solutions;

public class toeplitz_matrix {
	
	public boolean isToeplitzMatrix3(int[][] matrix) {
		for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] != matrix[i - 1][j - 1]){
                    return false;
                }
            }
        }

        return true;
	}
	
	public boolean isToeplitzMatrix2(int[][] matrix) {
		for(int i = 0; i < matrix.length - 1; i++) {
			for(int j = 0; j < matrix[i].length - 1; j++) {
				if(matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		return true;
	}
	
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
        	int curr = matrix[i][0];
        	int j = 0;
        	int tempI = i;
        	while( tempI < matrix.length && j < matrix[tempI].length ) {
        		if(matrix[tempI][j] != curr) {
        			return false;
        		}
        		tempI++; j++;
        	}
        }
        
    	for(int j = 0; j < matrix[0].length; j++) {
        	int curr = matrix[0][j];
        	int i = 0;
        	int tempJ = j;
        	while(i < matrix.length && tempJ < matrix[i].length) {
        		if(matrix[i][tempJ] != curr) {
        			return false;
        		}
        		i++; tempJ++;
        	}
    	}
    	
    	return true;
    }
}
