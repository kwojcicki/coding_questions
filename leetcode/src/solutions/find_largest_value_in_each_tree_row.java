package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class find_largest_value_in_each_tree_row {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        
        List<Integer> ret = new ArrayList<Integer>();
        
        if(root == null) {
        	return ret;
        }
        
        ret.add(root.val);

        q.add(root);
        
        while(!q.isEmpty()) {
        	TreeNode n = q.poll();
        	
        	if(n.val > ret.get(ret.size() - 1)) {
        		ret.set(ret.size() - 1, n.val);
        	}
        	
        	if(n.left != null) q2.add(n.left);
        	if(n.right != null) q2.add(n.right);
        	
        	if(q.isEmpty()) {
        		q = q2;
        		q2 = new LinkedList<TreeNode>();
        		if(!q.isEmpty()) ret.add(q.peek().val);
        	}
        	
        }
        
        return ret;
    }
}
