package solutions;

import java.util.List;

public class triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> copy = triangle.get(triangle.size() - 1);
        
        for(int i = triangle.size() - 2; i >= 0; i--) {
        	for(int col = 0; col <= i; col++) {
        		copy.set(col, triangle.get(i).get(col) + Math.min(copy.get(col), copy.get(col + 1)));
        	}
        }
        
        return copy.get(0);
    }
    
	// TLE
    public int minimumTotal1(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0, 0);
    }
    
    public int helper(List<List<Integer>> triangle, int row, int col, int total) {

    	if(row >= triangle.size()) {
    		return total;
    	}
    	
    	int left = helper(triangle, row + 1, col, total + triangle.get(row).get(col));
    	int right = helper(triangle, row + 1, col + 1, total + triangle.get(row).get(col));
    	
    	return Math.min(left, right);
    }
}
