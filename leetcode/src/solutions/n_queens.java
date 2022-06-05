package solutions;

import java.util.ArrayList;
import java.util.List;

public class n_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        boolean[][] placed = new boolean[n][n];
        
        solve(n, 0, placed, ret);
        return ret;
    }
    
    public void solve(int toPlace, int i, boolean[][] placed, List<List<String>> ret) {
    	if(toPlace == 0) {
    		ret.add(transcribe(placed));
    		return;
    	}
    	
    	for(; i < placed.length; i++) {
    		for(int j = 0; j < placed.length; j++) {
    			if(!placed[i][j] && valid(placed, i, j)) {
    				placed[i][j] = true;
    				solve(toPlace - 1, i + 1, placed, ret);
    				placed[i][j] = false;
    			}
    		}
    	}
    }
    
    public boolean valid(boolean[][] placed, int i, int j) {
    	for(int row = 0; row < placed.length; row++) {
    		if(row != i && placed[row][j]) {
    			return false;
    		}
    	}
    	
    	return valid(placed, i, j, new int[] { -1, 1}) &&
    			valid(placed, i, j, new int[] { 1, -1}) && 
    			valid(placed, i, j, new int[] { 1, 1}) && 
    			valid(placed, i, j, new int[] { -1, -1});
    }
    
    public boolean valid(boolean[][] placed, int i, int j, int[] dir) {
    	i -= dir[0];
    	j -= dir[1];
    	while(i >= 0 && j >= 0 && i < placed.length && j < placed.length) {
    		if(placed[i][j]) return false;
            i -= dir[0];
            j -= dir[1];
    	}
    	
    	return true;
    }
    
    public List<String> transcribe(boolean[][] placed){
    	List<String> ret = new ArrayList<>(placed.length);
    	for(int i = 0; i < placed.length; i++) {
    		StringBuilder sb = new StringBuilder(placed.length);
    		for(int j = 0; j < placed.length; j++) {
    			if(placed[i][j]) {
    				sb.append("Q");
    			} else {
    				sb.append(".");
    			}
    		}
            ret.add(sb.toString());
    	}
    	
    	return ret;
    }
    
    public static void main(String[] args) {
    	for(int i = 1; i <= 9; i++) {
    		System.out.println(i + " : " + new n_queens().solveNQueens(i).size());
    	}
    }
}
