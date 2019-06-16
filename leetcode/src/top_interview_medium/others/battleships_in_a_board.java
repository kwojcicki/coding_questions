package top_interview_medium.others;

public class battleships_in_a_board {
    public int countBattleships(char[][] board) {
     
    	int sum = 0;
    	
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[i].length; j++) {
    			
    			if(j > 0 && board[i][j - 1] == 'X') continue;
    			if(i > 0 && board[i - 1][j] == 'X') continue;
    			
    			if(board[i][j] == 'X') sum++;
    			
    		}
    	}
    	
    	return sum;
    }
}
