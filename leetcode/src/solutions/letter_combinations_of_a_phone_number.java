package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letter_combinations_of_a_phone_number {
	Map<Character, Character[]> mapping;
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        
        if(digits == null || digits.length() == 0) return ret;
        
        StringBuilder curr = new StringBuilder();
        
        mapping = new HashMap<>();
        mapping.put('2', new Character[] {'a', 'b', 'c'});
        mapping.put('3', new Character[] {'d', 'e', 'f'});
        mapping.put('4', new Character[] {'g', 'h', 'i'});
        mapping.put('5', new Character[] {'j', 'k', 'l'});
        mapping.put('6', new Character[] {'m', 'n', 'o'});
        mapping.put('7', new Character[] {'p', 'q', 'r', 's'});
        mapping.put('8', new Character[] {'t', 'u', 'v'});
        mapping.put('9', new Character[] {'w', 'x', 'y', 'z'});
        
        recurse(digits, 0, ret, curr);
        
        return ret;
    }
    
    public void recurse(String digits, int index, List<String> ret, StringBuilder curr) {
    	if(index == digits.length()) {
    		ret.add(curr.toString());
    		return;
    	}
    	
    	for(char c: mapping.get(digits.charAt(index))) {
    		curr.append(c);
    		recurse(digits, index + 1, ret, curr);
    		curr.setLength(curr.length() - 1);
    	}
    }
}
