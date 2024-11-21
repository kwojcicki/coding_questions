package solutions;

public class count_unguarded_cells_in_the_grid {
	
	public void bfs(int x, int y, int[][] board, int dirX, int dirY) {
		if(x < 0 || y < 0 || x >= board.length || y>= board[x].length) return;
		
		if(board[x][y] == 2) return;
		board[x][y] = 3;
		bfs(x + dirX, y + dirY, board, dirX, dirY);
	}
	
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] board = new int[m][n];
        for(int[] i: guards) board[i[0]][i[1]] = 2;
        for(int[] i: walls) board[i[0]][i[1]] = 2;
        
        for(int[] i: guards) {
            board[i[0]][i[1]] = 1;
        	bfs(i[0], i[1], board, 1, 0);
        	bfs(i[0], i[1], board, -1, 0);
        	bfs(i[0], i[1], board, 0, 1);
        	bfs(i[0], i[1], board, 0, -1);
            board[i[0]][i[1]] = 2;
        }
        
        int ret = 0;
        
        for(int[] is: board) {
            // System.out.println(Arrays.toString(is));
        	for(int i: is) if(i == 0) ret++;
        }
    	
    	return ret;
    }
}
