package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class palindrome_pairs {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		TrieNode root = new TrieNode();

		for(int i = 0; i < words.length; i++) {
			addWord(root, words[i], i);
		}

		for(int i = 0; i < words.length; i++) {
			find(root, words[i], i, ret);
		}

		return ret;
	}

	public void find(TrieNode root, String word, int index, List<List<Integer>> ret) {
		for(int i = 0; i < word.length(); i++) {
			if(root.index >= 0 && root.index != index && isPalindrome(word, i, word.length() - 1)){
				ret.add(Arrays.asList(index, root.index));
			}

			root = root.next[word.charAt(i) - 'a'];
			if(root == null) return;
		}

		for(int j: root.vals) {
			if(index == j) continue;
			ret.add(Arrays.asList(index, j));
		}
	}

	public void addWord(TrieNode root, String word, int index) {
		for(int j = word.length() - 1 ; j >= 0; j--) {
			if(root.next[word.charAt(j) - 'a'] == null) {
				root.next[word.charAt(j) - 'a'] = new TrieNode();
			}

			if(isPalindrome(word, 0, j)) {
				root.vals.add(index);
			}

			root = root.next[word.charAt(j) - 'a'];
		}

		root.index = index;
		root.vals.add(index);
	}

	public boolean isPalindrome(String word, int start, int end) {
		while(start < end) {
			if(word.charAt(start) != word.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

	private class TrieNode {
		int index = -1;
		TrieNode[] next = new TrieNode[26];
		List<Integer> vals = new ArrayList<>();
	}
}
