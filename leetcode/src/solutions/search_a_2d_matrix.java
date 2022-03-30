package solutions;

public class search_a_2d_matrix {
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int start = 0;
		int end = matrix.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(matrix[mid][0] == target) {
				return true;
			} else if(matrix[mid][0] > target) {
				end = mid - 1;
			} else if(matrix[mid][0] < target) {
				start = mid + 1;
			}
		}
		
		int row = end > 0 ? end : 0;
		
		System.out.println(row + " " + start + " " + end);
        
		start = 0;
		end = matrix[0].length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(matrix[row][mid] == target) {
				return true;
			} else if(matrix[row][mid] > target) {
				end = mid - 1;
			} else if(matrix[row][mid] < target) {
				start = mid + 1;
			}
		}
		
        int column = end > 0 ? end : 0;
		return matrix[row][column] == target;
	}
	
	public boolean searchMatrix1(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		
		int start = 0, end = matrix.length * matrix[0].length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
				return true;
			} else if(matrix[mid / matrix[0].length][mid % matrix[0].length] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		
		return false;
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = 0;
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        while(true) {
        	if(matrix[r][c] == target) {
        		return true;
        	} else if(matrix[r][c] > target) {
        		return false;
        	}
        	
        	if(r + 1 < matrix.length && matrix[r + 1][c] <= target) {
        		r++;
        	} else if(c + 1 < matrix[r].length && matrix[r][c + 1] <= target) {
        		c++;
        	} else {
        		break;
        	}
        }
        
        return false;
    }
}
