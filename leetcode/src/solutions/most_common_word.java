package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class most_common_word {
    public String mostCommonWord(String paragraph, String[] banned) {
    	String mostPopular = "";
    	int pop = -1;
    	Map<String, Integer> map = new HashMap<>();
    	Set<String> ban = new HashSet<>();
    	
    	for(String s: banned) {
    		ban.add(s);
    	}
    	
    	paragraph = paragraph.toLowerCase();
    	paragraph = paragraph.replaceAll("[!?',;\\.]", " ");
    	
    	for(String s: paragraph.split(" ")) {
    		if(ban.contains(s) || s.length() == 0) continue;
    		map.put(s, map.getOrDefault(s, 0) + 1);
    		if(map.get(s) > pop) {
    			mostPopular = s;
                pop = map.get(s);
    		}
    	}
    	
    	return mostPopular;
    }
}
