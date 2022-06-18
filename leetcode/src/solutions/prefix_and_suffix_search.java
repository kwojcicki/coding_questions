package solutions;

public class prefix_and_suffix_search {

	class WordFilter {

		Trie t = new Trie();
		public WordFilter(String[] words) {
			for(int j = 0; j < words.length; j++) {
				String word = words[j];
				for(int i = 0; i <= word.length(); i++) {
					t.insert(word.substring(word.length() - i, word.length()) + "{" + word, j);
				}
			}
		}

		public int f(String prefix, String suffix) {
			return t.get(suffix + "{" + prefix);
		}


		class TrieNode {

			private TrieNode[] links = new TrieNode[27];
			private boolean isEnd = false;
			private int index;

			public TrieNode(int index) {
				this.index = index;
			}

			public int getIndex() {
				return index;
			}

			public boolean has(char c) {
				return get(c) != null;
			}

			public TrieNode get(char c) {
				return links[c - 'a'];
			}

			public TrieNode getLast() {
				for(int i = links.length - 1; i >= 0; i--) {
					if(links[i] != null) return links[i];
				}

				return null;
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
				root = new TrieNode(-1);
			}

			/** Inserts a word into the trie. */
			public void insert(String word, int index) {
				TrieNode ptr = root;
				for(char c: word.toCharArray()) {
					if(!ptr.has(c)) {
						ptr.put(c, new TrieNode(index));
					}
					ptr.index = index;
					ptr = ptr.get(c);
				}
				ptr.index = index;
				ptr.setEnd();
			}

			public int get(String prefix) {

				TrieNode ptr = root;
				for(char c: prefix.toCharArray()) {
					if(ptr.has(c)) {
						ptr = ptr.get(c);
					} else {
						return -1;
					}
				}

				return ptr.index;
			}
		}
	}
}
