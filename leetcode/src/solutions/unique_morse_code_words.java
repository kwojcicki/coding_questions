package solutions;

import java.util.HashSet;
import java.util.Set;

public class unique_morse_code_words {
    public int uniqueMorseRepresentations(String[] words) {
        String[] trans = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word: words) {
        	StringBuilder t = new StringBuilder();
        	for(char c: word.toCharArray()) {
        		t.append(trans[c - 'a']);
        	}
        	set.add(t.toString());
        }
        return set.size();
    }
}
