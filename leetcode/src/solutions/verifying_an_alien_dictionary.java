package solutions;

import java.util.HashMap;
import java.util.Map;

public class verifying_an_alien_dictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c: order.toCharArray()) {
        	map.put(c, i++);
        }
        
        for(i = 0; i < words.length - 1; i++) {
        	if(!compare(words[i], words[i + 1], map)) return false;
        }
        
        return true;
    }
    
    public boolean compare(String word1, String word2, Map<Character, Integer> map) {
    	
    	int min = Math.min(word1.length(), word2.length());
    	for(int i = 0; i < min; i++) {
    		int compare = Integer.compare(map.get(word1.charAt(i)), map.get(word2.charAt(i)));
    		
    		if(compare > 0) return false;
            if(compare < 0) return true;
    		
    	}
    	
    	return word1.length() < word2.length();
    }
}
