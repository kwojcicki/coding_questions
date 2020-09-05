package solutions;

public class implement_trie_prefix_tree {

}

class TrieNode {
	
	private TrieNode[] links = new TrieNode[26];
	private boolean isEnd = false;
	
	public boolean has(char c) {
		return get(c) != null;
	}
	
	public TrieNode get(char c) {
		return links[c - 'a'];
	}
	
	public void put(char c, TrieNode t) {
		links[c - 'a'] = t;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	
	public void setEnd() {
		isEnd = true;
	}
	
}

class Trie {

	TrieNode root;
	
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode ptr = root;
        for(char c: word.toCharArray()) {
        	if(!ptr.has(c)) {
        		ptr.put(c, new TrieNode());
        	}
        	ptr = ptr.get(c);
        }
        ptr.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ptr = root;
    	for(char c: word.toCharArray()) {
    		if(ptr.has(c)) {
    			ptr = ptr.get(c);
    		} else {
    			return false;
    		}
    	}
    	
    	return ptr.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    	TrieNode ptr = root;
    	for(char c: prefix.toCharArray()) {
    		if(ptr.has(c)) {
    			ptr = ptr.get(c);
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */