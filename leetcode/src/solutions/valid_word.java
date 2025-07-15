package solutions;

import java.util.List;

public class valid_word {
    public boolean isValid(String word) {
        boolean vowel = false;
        boolean consonant = false;
        List<Character> vowels = List.of('a','i','e','o','u');
        if(word.length() < 3) return false;
    	
        for(char c: word.toCharArray()) {
            if(Character.isDigit(c)) continue;
        	if(('a' <= c && c <= 'z') 
        			|| ('A' <= c && c <= 'Z')) {
        		if(vowels.contains(Character.toLowerCase(c))) { vowel = true; } else {consonant = true; };
        	} else {
                //System.out.println(c);
        		return false;
        	}
        }
        
        //System.out.println(vowel + " " + consonant);
    	return vowel && consonant;
    }
}
