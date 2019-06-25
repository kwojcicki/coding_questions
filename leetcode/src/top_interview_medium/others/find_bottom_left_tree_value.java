package top_interview_medium.others;

import java.util.LinkedList;
import java.util.Queue;

public class find_bottom_left_tree_value {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> x = new LinkedList<TreeNode>();
        Queue<TreeNode> x2 = new LinkedList<TreeNode>();
        
        TreeNode left = root;
        
        x.add(root);
        while(!x.isEmpty()) {
        	
        	TreeNode n = x.poll();
        	if(n.left != null) x2.add(n.left);
        	if(n.right != null) x2.add(n.right);
        	
        	if(x.isEmpty()) {
        		x = x2;
        		x2 = new LinkedList<TreeNode>();
        		if(!x.isEmpty()) left = x.peek();
        	}
        	
        }
        
        
        return left.val;
    }
}
