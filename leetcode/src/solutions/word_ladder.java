package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class word_ladder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) {
			return 0;
		}

		Trie t = new Trie();
		for(String s: wordList) {
			t.insert(s);
		}

		int depth = 1;
		Queue<String> q = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		q.add(beginWord);

		while(!q.isEmpty()) {
			for(int i = q.size(); i > 0; i--) {
				String p = q.poll();

				if(seen.contains(p)) continue;
				if(p.equals(endWord)) return depth;

				q.addAll(t.getAll(p));
				seen.add(p);
			}
			depth++;
		}

		return 0;
	}

	class TrieNode {

		private TrieNode[] links = new TrieNode[26];
		private boolean isEnd = false;
		private String word = "";

		public boolean has(char c) {
			return get(c) != null;
		}

		public TrieNode get(char c) {
			return links[c - 'a'];
		}

		public TrieNode get(int c) {
			return links[c];
		}

		public void put(char c, TrieNode t) {
			links[c - 'a'] = t;
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(String word) {
			isEnd = true;
			this.word = word;
		}

		public String getWord() {
			return word;
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
			ptr.setEnd(word);
		}

		public List<String> getAll(String start){
			List<String> ret = new ArrayList<>();

			getAll(ret, 0, start, 0, root);
			System.out.println("---");
			System.out.println(start);
			System.out.println(ret);
			return ret;
		}

		private void getAll(List<String> ret, int index, String word, int changes, TrieNode root) {
			if(changes >= 2) {
				return;
			}

			if(index == word.length()) {
				if(root.isEnd && changes > 0) {
					ret.add(root.getWord());
				}
				return;
			}

			for(int i = 0; i < 26; i++) {
				if(root.get(i) != null) {
					getAll(ret, 
							index + 1, word, 
							changes + ( (i + 'a') == word.charAt(index) ? 0 : 1 ), root.get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new word_ladder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
	}

}
