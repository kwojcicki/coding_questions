package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class print_words_vertically {
    public List<String> printVertically(String s) {
    	String[] words = s.split(" ");
    	List<String> ret = new ArrayList<>();
    	int maxCount = Arrays.stream(words).mapToInt(i -> i.length()).max().getAsInt();
    	for(int i = 0; i < maxCount; i++) ret.add("");
    	
    	for(int l = 0; l < maxCount; l++) {
    		for(int i = 0; i < words.length; i++) {
    			if(words[i].length() > l) {
    				ret.set(l, ret.get(l) + words[i].charAt(l));
    			} else {
    				ret.set(l, ret.get(l) + " ");
    			}
    		}
    		
    		ret.set(l, ret.get(l).replaceFirst("\\s++$", ""));
    	}

    	
    	return ret;
    }
}
