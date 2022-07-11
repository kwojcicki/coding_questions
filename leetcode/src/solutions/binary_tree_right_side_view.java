package solutions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_right_side_view {
	
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> ret = new ArrayList<>();
    	helper(root, 0, ret);
    	return ret;
    }
    
    public void helper(TreeNode root, int level, List<Integer> ret) {
    	if(root == null) return;
    	
    	if(ret.size() == level) ret.add(root.val);
    	helper(root.right, level + 1, ret);
    	helper(root.left, level + 1, ret);
    }
	
    public List<Integer> rightSideView1(TreeNode root) {
    	List<Integer> ret = new ArrayList<Integer>();
    	
        if(root == null) return ret;
        
    	Deque<TreeNode> bfs = new LinkedList<>();

    	bfs.add(root);
    	
    	while(!bfs.isEmpty()) {
    		
    		ret.add(bfs.peekLast().val);
    		
    		for(int i = bfs.size() - 1; i >=0; i--) {
    			TreeNode x = bfs.pollFirst();
    			if(x.left != null) bfs.add(x.left);
    			if(x.right != null) bfs.add(x.right);
    		}
    	}
    	
    	return ret;
    }
}
