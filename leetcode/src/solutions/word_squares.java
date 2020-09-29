package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class word_squares {
	public static List<List<String>> wordSquares(String[] words) {
		List<List<String>> ret = new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for(String w: words) {
			for(int i = 1; i <= w.length(); i++) {
				if(!map.containsKey(w.substring(0, i))) {
					map.put(w.substring(0, i), new ArrayList<>());
				}

				map.get(w.subSequence(0, i)).add(w);
			}
		}

		//System.out.println(map);
		for(String w: words) {
			List<String> curr = new ArrayList<>();
			curr.add(w);

			recurse(words, ret, curr, map);
		}

		return ret;
	}

	public static void recurse(String[] words, List<List<String>> ret, List<String> curr, Map<String, List<String>> map) {
		if(curr.size() == words[0].length()) {
			//System.out.println(Arrays.toString(words) + " " + curr);

			//    		for(int word = 0; word < curr.size(); word++) {
			//    			String w = curr.get(word);
			//    			for(int i = 0; i < words[0].length(); i++) {
			//    				if(curr.get(i).charAt(word) != w.charAt(i)) {
			//    					return;
			//    				}
			//    			}
			//    		}

			List<String> a = new ArrayList<>();
			for(String w: curr) {
				a.add(w);
			}
			ret.add(a);

			return;
		}

		StringBuilder prefix = new StringBuilder();
		for(String w: curr) {
			prefix.append(w.charAt(curr.size()));
		}

		//System.out.println("here: " + curr + " " + prefix);
		if(!map.containsKey(prefix.toString())) return;

		for(String w: map.get(prefix.toString())) {
			curr.add(w);
			//System.out.println(curr);
			recurse(words, ret, curr, map);
			curr.remove(curr.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(wordSquares(new String[] {"area","lead","wall","lady","ball"}));
		System.out.println(wordSquares(new String[] {"abat","baba","atan","atal"}));

	}
}
