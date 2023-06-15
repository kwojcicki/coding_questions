package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class maximum_level_sum_of_a_binary_tree {
    public int maxLevelSum(TreeNode root) {
    	int ret = 0;
        int max = Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lvl = 1;
        while(!q.isEmpty()) {
        	int curr = 0;
        	for(int i = q.size(); i > 0; i--) {
        		TreeNode n = q.poll();
        		curr += n.val;
        		if(n.left != null) q.add(n.left);
        		if(n.right != null) q.add(n.right);
        	}
        	if(curr > max) {
        		ret = lvl;
        		max = curr;
        	}
        	lvl++;
        }
        
        return ret;
    }
}
