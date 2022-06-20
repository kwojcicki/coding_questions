package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class short_encoding_of_words {

    public int minimumLengthEncoding(String[] words) {
        int ret = 0;
        
        Set<String> seen = new HashSet<>();
        Arrays.sort(words, (a,b) -> Integer.compare(b.length(), a.length()));
        
        for(String word: words) {
        	if(seen.contains(word)) {
        		continue;
        	}
        	ret += word.length() + 1;
        	for(int i = 0; i < word.length(); i++) {
        	    seen.add(word.substring(i, word.length()));
        	}
        }
        
        return ret;
    }
}
