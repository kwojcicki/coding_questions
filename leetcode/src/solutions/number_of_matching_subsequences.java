package solutions;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class number_of_matching_subsequences {

    public int numMatchingSubseq(String s, String[] words) {
    	int ret = 0;
    	List<List<StringCharacterIterator>> iters = new ArrayList<>(26);
    	for(int i = 0; i < 26; i++) iters.add(new ArrayList<>());
    	
    	for(String word: words) {
    		iters.get(word.charAt(0) - 'a').add(new StringCharacterIterator(word));
    	}
    	
    	for(char c: s.toCharArray()) {
    		List<StringCharacterIterator> its = iters.set(c - 'a', new ArrayList<>());
    		for(StringCharacterIterator it: its) {
    			if(it.next() == CharacterIterator.DONE) ret++;
    			else iters.get(it.current() - 'a').add(it);
    		}
    	}
    	
    	return ret;
    }
	
	// TLE
    public int numMatchingSubseq1(String s, String[] words) {
        int ret = 0;
        
        for(String word: words) {
        	int left = 0;
        	int right = 0;
        	
        	while(left < s.length() && right < word.length()) {
        		if(s.charAt(left) == word.charAt(right)) {
        			right++;
        		}
        		left++;
        	}
        	
        	if(right == word.length()) ret++;
        }
        
        return ret;
    }
}
