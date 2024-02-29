package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class even_odd_tree {
	public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int lvl = 0;
        int prev = 0;
        boolean odd = false;
        q.add(root);
        while(!q.isEmpty()) {
        	odd = lvl % 2 == 1;
        	prev = !odd ? -1 : Integer.MAX_VALUE;
        	for(int i = q.size() - 1; i >= 0; i--) {
        		TreeNode n = q.poll();
                // System.out.println(prev + " " + n.val + " " + odd);
        		if(odd && (prev <= n.val || n.val % 2 != 0)) {
        			return false;
        		} else if (!odd && (prev >= n.val || n.val % 2 != 1)) {
        			return false;
        		}
                prev = n.val;
        		if(n.left != null) q.add(n.left);
        		if(n.right != null) q.add(n.right);
        	}
            lvl++;
        }
        
    	return true;
    }
}
