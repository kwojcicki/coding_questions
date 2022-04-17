package solutions;

import java.util.HashSet;
import java.util.Set;

public class lowest_common_ancestor_of_a_binary_tree_iii {
    public Node lowestCommonAncestor(Node p, Node q) {
    	Node tmpP = p, tmpQ = q;
    	while(tmpP != tmpQ) {
    		tmpP = tmpP == null ? q : tmpP.parent;
    		tmpQ = tmpQ == null ? p : tmpQ.parent;
    	}
    	
    	return tmpP;
    }
    
    public Node lowestCommonAncestor1(Node p, Node q) {
        Set<Integer> seen = new HashSet<>();
        
        Node tempP = p;
        while(tempP != null) {
        	seen.add(tempP.val);
        	tempP = tempP.parent;
        }
        
        Node tempQ = q;
        while(!seen.contains(tempQ.val)) {
        	tempQ = tempQ.parent;
        }
        
        return tempQ;
    }
}
