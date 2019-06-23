package top_interview_medium.others;

public class binary_tree_pruning {
    public TreeNode pruneTree(TreeNode root) {
        if(recurse(root)) {
        	return root;
        }
        
        return null;
    }
    
    public static boolean recurse(TreeNode node) {
    	
    	if(node == null) {
    		return false;
    	}   		
    	
		boolean left = recurse(node.left);
		boolean right = recurse(node.right);

		if(!left) {
			node.left = null;
		}
		if(!right) {
			node.right = null;
		}
		
    	if(node.val == 1 || left || right) {
    		return true;
    	}
    	
    	return false;
    	
    }
}
