package solutions;

import java.util.Arrays;

public class spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int i = 0;
        int j = 0;
        int curr = 1;
        
        int[][] directions = new int[][] { {0, 1}, {1,0}, {0, -1}, {-1, 0} };
        int direction = 0;
        
        while(true) {
        	System.out.println(i + " " + j + " " + direction);
        	
        	ret[i][j] = curr;
        	curr++;
        	
        	if(i + directions[direction][0] < n 
        			&& i + directions[direction][0] >= 0 
        			&& j + directions[direction][1] < n
        			&& j + directions[direction][1] >= 0 
        			&& ret[i + directions[direction][0]][j + directions[direction][1]] == 0) {
        		i += directions[direction][0];
        		j += directions[direction][1];
        	} else {
        		direction = (direction + 1) % 4;
        		if(i + directions[direction][0] < n 
            			&& i + directions[direction][0] >= 0 
            			&& j + directions[direction][1] < n
            			&& j + directions[direction][1] >= 0 
            			&& ret[i + directions[direction][0]][j + directions[direction][1]] == 0) {
            		i += directions[direction][0];
            		j += directions[direction][1];
        		} else {
        			break;
        		}
        	}
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	for(int[] a: new spiral_matrix_ii().generateMatrix(1)) {
    		System.out.println(Arrays.toString(a));
    	}
    }
}
