package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class word_squares {
    public static List<List<String>> wordSquares(String[] words) {
    	List<List<String>> ret = new ArrayList<>();
    	
    	recurse(words, ret, new ArrayList<String>());
    	
    	return ret;
    }
    
    public static void recurse(String[] words, List<List<String>> ret, List<String> curr) {
    	if(curr.size() == words[0].length()) {
    		//System.out.println(Arrays.toString(words) + " " + curr);
    		
    		for(int word = 0; word < curr.size(); word++) {
    			String w = curr.get(word);
    			for(int i = 0; i < words[0].length(); i++) {
    				if(curr.get(i).charAt(word) != w.charAt(i)) {
    					return;
    				}
    			}
    		}
    		
    		List<String> a = new ArrayList<>();
    		for(String w: curr) {
    			a.add(w);
    		}
    		ret.add(a);
    		
    		return;
    	}
    	
    	for(String w: words) {
    		curr.add(w);
    		recurse(words, ret, curr);
    		curr.remove(curr.size() - 1);
    	}
    }
    
    public static void main(String[] args) {
    	System.out.println(wordSquares(new String[] {"area","lead","wall","lady","ball"}));
    	System.out.println(wordSquares(new String[] {"abat","baba","atan","atal"}));
    	
    }
}
