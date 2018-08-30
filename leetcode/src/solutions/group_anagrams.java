package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> toReturn = new HashMap<String, List<String>>();
    	for(String s: strs) {
    		char[] c = s.toCharArray();
    		Arrays.sort(c);
    		
    		if(!toReturn.containsKey(String.valueOf(c))) {
    			toReturn.put(String.valueOf(c), new ArrayList<String>());
    		}
    		
    		toReturn.get(String.valueOf(c)).add(s);
    	}
    	
    	return new ArrayList<List<String>>(toReturn.values());
    }
}
