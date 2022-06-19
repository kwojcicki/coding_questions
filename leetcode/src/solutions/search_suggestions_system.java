package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class search_suggestions_system {

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> ret = new ArrayList<>(searchWord.length());

		for(int i = 0; i < searchWord.length(); i++) {
			ret.add(new ArrayList<>());
		}

		Trie t = new Trie();
		for(String product: products) {
			t.insert(product);
		}

		for(int i = 0; i < searchWord.length(); i++) {
			ret.set(i, t.get(searchWord.substring(0, i + 1)));
		}

		return ret;
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

		public List<String> get(String prefix) {

			TrieNode ptr = root;
			for(char c: prefix.toCharArray()) {
				if(ptr.has(c)) {
					ptr = ptr.get(c);
				} else {
					return new ArrayList<>();
				}
			}

			List<String> ret = new ArrayList<>();
			dfs(ptr, ret, new StringBuilder(prefix));
			return ret;
		}

		public void dfs(TrieNode ptr, List<String> ret, StringBuilder curr) {
			if(ret.size() == 3) return;

			if(ptr.isEnd) {
				ret.add(curr.toString());
			}

			for(int i = 0; i < 26; i++) {
				if(ptr.has((char)('a' + i))) {
					curr.append((char)('a' + i));
					dfs(ptr.get((char)('a' + i)), ret, curr);
					curr.setLength(curr.length() - 1);
				}
			}
		}
	}

	public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
		Arrays.sort(products);

		List<List<String>> ret = new ArrayList<>(searchWord.length());

		for(int i = 0; i < searchWord.length(); i++) {
			ret.add(new ArrayList<>());
		}

		for(String product: products) {
			for(int i = 0; i < product.length() && i < searchWord.length(); i++) {
				if(searchWord.startsWith(product.substring(0, i + 1))) {
					if(ret.get(i).size() < 3)
						ret.get(i).add(product);
				} else {
					break;
				}
			}
		}

		return ret;
	}
}
