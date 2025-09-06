package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sudoku_solver {
	List<Set<Character>> rows = new ArrayList<>();
	List<Set<Character>> cols = new ArrayList<>();
	List<Set<Character>> squares = new ArrayList<>();
    public void solveSudoku(char[][] board) {
    	
    	for(int i = 0; i < 9; i++) {
    		rows.add(new HashSet<>());
    		cols.add(new HashSet<>());
    		squares.add(new HashSet<>());
    	}
    	
    	for(int r = 0; r < board.length; r++) {
    		for(int c = 0; c < board[r].length; c++) {
    			if(board[r][c] != '.') {
    				rows.get(r).add(board[r][c]);
    				cols.get(c).add(board[r][c]);
    				squares.get((r / 3) * 3 + c / 3).add(board[r][c]);
    			}
    		}
    	}
    	
    	solve(0, 0, board);
    }
    
    public boolean solve(int r, int c, char[][] board) {
    	if(r >= board.length) return true;
    	if(c >= board[r].length) return solve(r + 1, 0, board);
    	
    	if(board[r][c] != '.') return solve(r, c + 1, board);
    	
    	for(int i = 1; i <= 9; i++) {
    		char toPut = (char) ('0' + i);
    		
    		if(rows.get(r).contains(toPut) || cols.get(c).contains(toPut)
    		 || squares.get((r / 3) * 3 + c / 3).contains(toPut)) {
    			continue;
    		}
    		
    		rows.get(r).add(toPut);
    		cols.get(c).add(toPut);
    		squares.get((r / 3) * 3 + c / 3).add(toPut);
    		
    		board[r][c] = toPut;
    		if(solve(r, c + 1, board)) {
    			return true;
    		}
    		
    		rows.get(r).remove(toPut);
    		cols.get(c).remove(toPut);
    		squares.get((r / 3) * 3 + c / 3).remove(toPut);
    	}
    	
    	board[r][c] = '.';
    	
    	return false;
    }
}
