package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class generate_parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        helper(new StringBuilder(""), 0, n * 2, ret);
        return ret;
    }
	
	public void helper(StringBuilder curr, int open, int n, List<String> ret) {
        // if(curr.length() + open > n) return;
        
		if(n == 0) {
			if(open != 0) return;
			ret.add(curr.toString());
			return;
		}
		
		if(open > 0) {
			curr.append(")");
			helper(curr, open - 1, n - 1, ret);
			curr.setLength(curr.length() - 1);
		}
		
		curr.append("(");
		helper(curr, open + 1, n - 1, ret);
		curr.setLength(curr.length() - 1);
	}
	
    public List<String> generateParenthesis1(int n) {
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
