package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class word_ladder_ii {

	public List<List<String>> findLadders(
			String beginWord, 
			String endWord, 
			List<String> wordList) {
		List<List<String>> ret = new ArrayList<>();
		Set<String> words = new HashSet<>(wordList);
		if(!words.contains(endWord)) return ret;

		Map<String, List<String>> map = new HashMap<>();
		generateMap(beginWord, endWord, words, map);
		dfs(beginWord, endWord, map, ret, new ArrayList<>());
		return ret;
	}

	private Set<String> visitedDfs = new HashSet<>();
	private void dfs(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> ret, List<String> curr) {
		if (visitedDfs.contains(beginWord)) {
			return;
		}
		if(beginWord.equals(endWord)) {
			List<String> tmp = new ArrayList<>(curr);
			tmp.add(endWord);
			ret.add(tmp);
			visitedDfs = new HashSet<>();
			return;
		}

		if(!map.containsKey(beginWord)) return;
		visitedDfs.add(beginWord);
		curr.add(beginWord);
		for(String next: map.get(beginWord)) {
			dfs(next, endWord, map, ret, curr);
		}
		curr.remove(curr.size() - 1);
	}

	private void generateMap(String beginWord, String endWord, Set<String> words, Map<String, List<String>> map) {
		ArrayDeque<String> q = new ArrayDeque<>();
		Set<String> seen = new HashSet<>();
		List<String> start = new LinkedList<>();
		start.add(beginWord);
		words.remove(beginWord);
		q.add(beginWord);
		while(!q.isEmpty() && !seen.contains(endWord)) {
			Set<String> toRemove = new HashSet<>();
			for(int j = q.size() - 1; j >= 0; j--) {
				String word = q.pollFirst();

				List<String> nextWords = getNext(word, words);
				for(String next: nextWords) {
					toRemove.add(next);
					map.putIfAbsent(word, new ArrayList<>());
					map.get(word).add(next);
					if(seen.add(next)) q.add(next);
				}

			}

			for(String w: toRemove) {
				words.remove(w);
			}
		}
	}

	// TLE
	public List<List<String>> findLadders1(
			String beginWord, 
			String endWord, 
			List<String> wordList) {
		List<List<String>> ret = new ArrayList<>();
		Set<String> words = new HashSet<>(wordList);
		if(!words.contains(endWord)) return ret;

		ArrayDeque<List<String>> q = new ArrayDeque<>();
		List<String> start = new LinkedList<>();
		start.add(endWord);
		words.remove(endWord);
		q.add(Arrays.asList(endWord));
		while(!q.isEmpty()) {
			Set<String> toRemove = new HashSet<>();
			for(int j = q.size() - 1; j >= 0; j--) {
				List<String> n = q.pollFirst();
				String word = n.get(n.size() - 1);

				List<String> nextWords = getNext(word, words);
				for(String next: nextWords) {
					List<String> newPath = new ArrayList<>(n);
					newPath.add(next);
					toRemove.add(next);
					if(next.equals(beginWord)) {
						ret.add(newPath);
					} else {
						q.add(newPath);
					}
				}

			}
			for(String w: toRemove) {
				words.remove(w);
			}
		}

		return ret;
	}

	public List<String> getNext(String word, Set<String> words){
		List<String> ret = new LinkedList<>();
		for(String w: words) {
			int diff = 0;
			for(int i = 0 ; i < word.length() && diff < 2; i++) {
				if(word.charAt(i) != w.charAt(i)) diff++;
			}
			if(diff == 1) ret.add(w);
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new word_ladder_ii().findLadders("red", "tax", 
				Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")));
	}
}
