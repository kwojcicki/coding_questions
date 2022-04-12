package solutions;

public class game_of_life {

	public int get(int[][] board, int x, int y) {
		if(x < 0 || y < 0 || x >= board.length || y >= board[x].length) {
			return 0;
		}

		if(board[x][y] == 1 || board[x][y] == -1) {
			return 1;
		}

		return 0;
	}

	public void gameOfLife(int[][] board) {
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {

				int sum = 
						get(board, x - 1, y) + 
						get(board, x, y - 1) + 
						get(board, x + 1, y) + 
						get(board, x, y + 1) +
						get(board, x - 1, y + 1) +
						get(board, x + 1, y - 1) +
						get(board, x + 1, y + 1) +
						get(board, x - 1, y - 1);

				if(board[x][y] == 1) {
					if(sum == 2 || sum == 3) {
						board[x][y] = 1;
					} else {
						board[x][y] = -1;
					}
				} else {
					if(sum == 3) {
						board[x][y] = -2;
					}
				}
			}
		}

		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[x].length; y++) {
				if(board[x][y] == -1) board[x][y] = 0;
				else if(board[x][y] == -2) board[x][y] = 1;
			}
		}
	}
}
