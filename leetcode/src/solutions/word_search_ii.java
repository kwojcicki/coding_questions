package solutions;

import java.util.ArrayList;
import java.util.List;

public class word_search_ii {
	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		boolean hasNext = true;
	}
	
	public void dfs(char[][] board, boolean[][] seen, int r, int c, String[] words, StringBuilder curr, TrieNode root, List<String> ret) {

		if(r < 0 || r >= seen.length || c < 0 || c >= seen[0].length || seen[r][c]) {
			return;
		}
		
		curr.append(board[r][c]);
		root = root.next[board[r][c] - 'a'];
		
		if(root == null) {
			curr.setLength(curr.length() - 1);
			return;
		} else if(!root.hasNext) {
			ret.add(curr.toString());
			root.hasNext = true;
		}
		
		seen[r][c] = true;
		
		dfs(board, seen, r + 1, c, words, curr, root, ret);
		dfs(board, seen, r - 1, c, words, curr, root, ret);
		dfs(board, seen, r, c + 1, words, curr, root, ret);
		dfs(board, seen, r, c - 1, words, curr, root, ret);
		
		seen[r][c] = false;
		curr.setLength(curr.length() - 1);
	}
	
    public List<String> findWords(char[][] board, String[] words) {
    	TrieNode root = new TrieNode();
    	List<String> ret = new ArrayList<>();
    	
    	for(String word: words) {
        	TrieNode ptr = root;
    		for(char c: word.toCharArray()) {
    			if(ptr.next[c - 'a'] == null) {
    				ptr.next[c - 'a'] = new TrieNode();
    			}
    			ptr = ptr.next[c - 'a'];
    		}
    		ptr.hasNext = false;
    	}
    	
    	boolean[][] seen = new boolean[board.length][board[0].length];
    	
    	for(int r = 0; r < board.length; r++) {
    		for(int c = 0; c < board[0].length; c++) {
    			dfs(board, seen, r, c, words, new StringBuilder(), root, ret);
    		}
    	}
    	
    	return ret;
    }
}

