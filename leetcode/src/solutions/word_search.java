package solutions;

public class word_search {
    public boolean exist(char[][] board, String word) {
		if(word == null || word.equals("")) return true;

		boolean found = false;

		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c] == word.charAt(0)) {
                    //System.out.println(r + " " + c);
					found = found || dfs(board, r, c, word, 0);
                    if(found) return found;
				}
			}
		}

		return false;
	}

	public boolean dfs(char[][] board, int r, int c, String word, int index) {
        
        if(index == word.length()) return true;

		if(r < 0 || c < 0 || r >= board.length || c >= board[r].length || board[r][c] == '.') return false;
        
        
		if(board[r][c] != word.charAt(index)) return false;

		char t = board[r][c];
		board[r][c] = '.';

		boolean result =  dfs(board, r + 1, c, word, index + 1) ||
				dfs(board, r - 1, c, word, index + 1) ||
				dfs(board, r, c + 1, word, index + 1) ||
				dfs(board, r, c - 1, word, index + 1);
		
		board[r][c] = t;
		return result;
	}
}
