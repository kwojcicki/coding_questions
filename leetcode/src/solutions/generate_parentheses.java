package solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        Set<String> ret = new HashSet<>();
        
        recurse(ret, "", n * 2, 0, 0);
        
        return ret.stream().collect(Collectors.toList());
    }
    
    public void recurse(Set<String> ret, String curr, int pairs, int open, int closed) {
    	if(curr.length() == pairs) {
    		ret.add(curr);
    		return;
    	}
    	
    	if(open > closed) {
    		recurse(ret, curr + ")", pairs, open, closed + 1);
    	}
    	if( pairs / 2 > open ){
    		recurse(ret, curr + "(", pairs, open + 1, closed);
    	}
    }
}
