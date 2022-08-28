package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class sort_the_matrix_diagonally {
    public int[][] diagonalSort(int[][] mat) {
    	Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
    	for(int i = 0; i < mat.length; i++) {
    		for(int j = 0; j < mat[i].length; j++) {
    			m.putIfAbsent(i - j, new PriorityQueue<>());
    			m.get(i - j).add(mat[i][j]);
    		}
    	}
    	
    	for(int i = 0; i < mat.length; i++) {
    		for(int j = 0; j < mat[i].length; j++) {
    			mat[i][j] = m.get(i - j).poll();
    		}
    	}
    	
        return mat;
    }
}
