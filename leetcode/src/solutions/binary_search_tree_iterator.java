package solutions;

import java.util.Stack;

public class binary_search_tree_iterator {
	class BSTIterator {

		Stack<TreeNode> s = new Stack<>();
        TreeNode root = null;
	    public BSTIterator(TreeNode root) {
            this.root = root;
	    }
	    
	    public int next() {
	        while(root != null){
                s.add(root);
                root = root.left;
            }
            
            TreeNode curr = s.pop();
            root = curr.right;
            
            return curr.val;
	    }
	    
	    public boolean hasNext() {
	        return !s.isEmpty() || root != null;
	    }
	}
}
