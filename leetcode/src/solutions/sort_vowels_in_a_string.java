package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sort_vowels_in_a_string {
    public String sortVowels(String s) {
    	Map<Character, Integer> cnts = new HashMap<>();
    	char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };
    	Set<Character> vowelSet = new HashSet<Character>();
    	for(char c: vowels) vowelSet.add(c);
    	
    	char[] ret = s.toCharArray();
    	
    	for(char c: s.toCharArray()) {
    		if(vowelSet.contains(c)) {
    			cnts.compute(c, (k,v) -> v == null ? 1 : v + 1);
    		}
    	}
    	
    	int vIndex = 0;
    	for(int i = 0; i < ret.length; i++) {
    		if(vowelSet.contains(ret[i])) {
    			while(cnts.getOrDefault(vowels[vIndex], 0) == 0) {
    				vIndex++;
    			}
    			cnts.compute(vowels[vIndex], (k,v) -> v - 1);
    			ret[i] = vowels[vIndex];
    		}
    	}
    	
    	return new String(ret);
    }
}
