package solutions;

import java.util.ArrayList;
import java.util.List;

public class binary_tree_preorder_traversal {
	public List<Integer> preorderTraversal(TreeNode root) {
    	return helper(root, new ArrayList<>());
    }
    
    public List<Integer> helper(TreeNode root, List<Integer> l){
    	if(root == null) { return l;}
    	l.add(root.val);
        if(root.left == root.right) return l;
    	helper(root.left, l);
    	helper(root.right, l);
    	return l;
    }
}
