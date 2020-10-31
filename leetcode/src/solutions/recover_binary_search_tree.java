package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class recover_binary_search_tree {
    public void recoverTree(TreeNode root) {
        
    	TreeNode x = null, y = null, prev = null;
    	
    	Deque<TreeNode> s = new LinkedList<>();
    	
    	while(!s.isEmpty() || root != null) {
    		while(root != null) {
    			s.add(root);
    			root = root.left;
    		}
    		
    		root = s.pollLast();
    		
    		if(prev != null && root.val < prev.val) {
    			y = root;
    			if(x == null) x = prev;
    			else break;
    		}
    		
    		prev = root;
    		root = root.right;
    	}
    	
    	if(x != null) {
    		int tmp = x.val;
    		x.val = y.val;
    		y.val = tmp;
    	}
    }
}
