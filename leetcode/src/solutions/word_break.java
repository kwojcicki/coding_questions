package solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class word_break {
	Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }
    
    public boolean wordBreak(String s, List<String> wordDict, int start) {
        
    	if(memo.containsKey(start)) {
    		return memo.get(start);
    	}
    	
        if(start == s.length()) return true;
        
    	for(int i = start; i < s.length(); i++) {
            //System.out.println(s.substring(start, i + 1));
    		if(wordDict.contains(s.substring(start, i + 1))) {
    			if(wordBreak(s, wordDict, i + 1)) {
    				memo.put(start, true);
    				return true;
    			} else {
    				memo.put(start, false);
    			}
    		}
    	}
    	
    	memo.put(start, false);
    	return false;
    }
}
