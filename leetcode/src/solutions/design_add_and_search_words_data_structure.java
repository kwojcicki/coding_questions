package solutions;

public class design_add_and_search_words_data_structure {
	
	class TrieNode {
		
		private TrieNode[] children = new TrieNode[26];
		private boolean end = false;
		public TrieNode() {}
		
		public void add(char[] c, int index) {
			if(index == c.length) {
				end = true;
				return;
			}
			
			if(children[c[index] - 'a'] == null) {
				children[c[index] - 'a'] = new TrieNode();
			}
			
			TrieNode child = children[c[index] - 'a'];
			child.add(c,  index + 1);
		}
		
		public boolean contains(char[] c, int index) {
			if(index == c.length) return this.ends();
			
			if(c[index] == '.') {
				
				boolean flag = false; 
				for(TrieNode child: children) {
					if(child != null) {
						flag |= child.contains(c, index+1);
					}
				}
				return flag;
			}
			
			TrieNode child = children[c[index] - 'a'];
			return child == null ? false : child.contains(c, index + 1); 
		}
		
		public boolean ends(){
			return end;
		}
	}
	
	class WordDictionary {
		private TrieNode start;
	    public WordDictionary() {
	        start = new TrieNode();
	    }
	    
	    public void addWord(String word) {
	        start.add(word.toCharArray(), 0);
	    }
	    
	    public boolean search(String word) {
	        return start.contains(word.toCharArray(), 0);
	    }
	}
	
	public static void main(String[] args) {
		
		design_add_and_search_words_data_structure.WordDictionary wd 
			= new design_add_and_search_words_data_structure().new WordDictionary();
		
		wd.addWord("a");
		wd.addWord("ab");
		
		System.out.println(wd.search("a."));
		System.out.println(wd.search("a"));
		System.out.println(wd.search("ab"));
		System.out.println(wd.search(".a"));
		System.out.println(wd.search(".b"));
	}
}
