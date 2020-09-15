package solutions;

public class inorder_successor_in_bst_ii {
    public Node inorderSuccessor(Node node) {
        
        Node ret = node;
    	Node past = null;
    	
    	if(ret == null || (ret.parent == null && ret.right == null)) return null;
    	
    	while(ret != null) {
            
    		if(ret.right != null && ret.right != past) {
                ret = ret.right;
    			while(ret.left != null) ret = ret.left;
    			break;
    		}
    		
    		past = ret;
    		ret = ret.parent;
    		
    		if(ret.parent == null && past == ret.left) return ret;
    		if(ret.parent == null && past == ret.right) return null;
            if(ret.left == past) return ret;
    		
    	}
    	
    	return ret;
    }
}
