package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class substring_with_concatenation_of_all_words {

	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int totalSize = words[0].length() * words.length;
        
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
        	map.compute(word, (k,v) -> v == null ? 1 : v + 1);
        }
        
        for(int i = 0; i < words[0].length(); i++) {
            // System.out.println(i);
        	helper(s, i, words[0].length(), map, words.length, totalSize, ret);
        }
        
        return ret;
    }

	private void helper(String s, int index, int size, Map<String, Integer> map, int wordsSize, int totalSize, List<Integer> ret) {
		Map<String, Integer> currMap = new HashMap<>(map);
		int curr = wordsSize;
		for(int i = index; i + size <= s.length(); i += size) {
			String word = s.substring(i, i + size);
            // System.out.println(word);
            if(!currMap.containsKey(word)){
                currMap = new HashMap<>(map);
                curr = wordsSize;
            } else {
                while(currMap.get(word) == 0){
                    // System.out.println("empty");
                    String tmp = s.substring(i -(wordsSize - curr) * size, i - (wordsSize - curr) * size + size);
                    currMap.compute(tmp, (k, v) -> v + 1);
                    curr++;
                }
                curr--;
                currMap.compute(word, (k, v) -> v - 1);
            }

            // System.out.println(currMap);
			if(curr == 0) {
				ret.add(i - totalSize + size);
				currMap.put(s.substring(i - totalSize + size, i - totalSize + size + size ), 1);
				curr = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Set<String> test1 = new HashSet<>();
		test1.add("1");
		test1.add("2");
		Set<String> test2 = new HashSet<>(test1);
		test2.remove("3");
		System.out.println(test2);
		test2 = new HashSet<>(test1);
		System.out.println(test1);
		System.out.println(test2);
	}
}
