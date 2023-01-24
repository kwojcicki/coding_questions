package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class snakes_and_ladders {
	public int snakesAndLadders(int[][] board) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        seen.add(0);
        q.add(0);
        int	moves = 0;
        
        while(!q.isEmpty()) {
        	for(int s = q.size() - 1; s >= 0; s--) {
                int i = q.poll();
        		if(i == board.length * board.length - 1) return moves;
        		
                for(int j = 1; j <= 6 && i + j < board.length * board.length; j++){
                    int[] tPos = getPos(i + j, board);
                    int tVal = board[tPos[0]][tPos[1]];
                    if(tVal != -1){
                        if(seen.add(tVal -1)){
                            q.add(tVal - 1);
                        }
                    } else if(seen.add(i + j)){
                        q.add(i + j);
                    }
                }
        	}
        	moves++;
        }
        
        return -1;
    }

    public static int[] getPos(int i, int[][] board){
        int row = board.length - (i / board.length) - 1;
        int col = (board.length - row) % 2 == 1 ? (i % board.length) : 
            (board.length - (i % board.length) - 1);
        return new int[]{ row, col };
    }
}
