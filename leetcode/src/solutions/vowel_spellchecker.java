package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class vowel_spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
String[] ret = new String[queries.length];
        
        Set<String> wordSet = new HashSet<>();
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for(String w: wordlist) {
        	wordSet.add(w);
        	cap.putIfAbsent(w.toLowerCase(), w);
        	
        	String withoutVowels = w.toLowerCase().replaceAll("[aeiou]", "-");
        	vowel.putIfAbsent(withoutVowels, w);
        }
        
        for(int i = 0; i < queries.length; i++) {
        	String q = queries[i];
        	if(wordSet.contains(q)) {
        		ret[i] = q;
        	} else {
        		ret[i] = cap.getOrDefault(q.toLowerCase(), 
        			vowel.getOrDefault(q.toLowerCase().replaceAll("[aeiou]", "-"), ""));
        	}
        }
        
        return ret;
    }
}
