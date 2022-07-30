package solutions;

import java.util.ArrayList;
import java.util.List;

public class word_subsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ret = new ArrayList<>();
        
        int[] sum = new int[26];
        for(String word: words2) {
        	int[] tmp = transform(word);
        	for(int i = 0; i < sum.length; i++) {
        		sum[i] = Math.max(sum[i], tmp[i]);
        	}
        }
        
        for(String word: words1) {
        	if(matches(transform(word), sum)) {
        		ret.add(word);
        	}
        }
        
        return ret;
    }
    
    public boolean matches(int[] left, int[] right) {
    	for(int i = 0; i < left.length; i++) {
    		if(left[i] < right[i]) return false;
    	}
    	
    	return true;
    }
    
    public int[] transform(String word) {
    	int[] count = new int[26];
    	for(char c: word.toCharArray()) {
    		count[c - 'a']++;
    	}
    	
    	return count;
    }
}
