package top_interview_easy.array;

import java.util.HashSet;
import java.util.Set;

public class valid_sudoku {
	
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<String>();
        
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		if(board[i][j] == '.') continue;
        		if(!set.add("column(" + board[i][j] + ")" + i) || 
        				!set.add("row(" + board[i][j] + ")" + j) || 
        				!set.add("corner(" + board[i][j] + ")" + i/3 + "-" + j/3)) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}
