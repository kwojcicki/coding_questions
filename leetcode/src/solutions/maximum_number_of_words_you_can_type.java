package solutions;

import java.util.HashSet;
import java.util.Set;

public class maximum_number_of_words_you_can_type {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ret = 0;
        Set<Character> chars = new HashSet<>();
        for(char c: brokenLetters.toCharArray()) chars.add(c);
        
        for(String word: text.split(" ")) {
        	boolean valid = true;
        	for(char c: word.toCharArray()) if(chars.contains(c)) { valid = false; break; }
        	ret += valid ? 1 : 0;
        }
        
        return ret;
    }
}
