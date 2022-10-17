package solutions;

import java.util.HashSet;
import java.util.Set;

public class check_if_the_sentence_is_pangram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        
        for(char c: sentence.toCharArray()) {
        	s.add(c);
        }
    	
    	return s.size() == 26; 
    }
}
