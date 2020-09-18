package solutions;

import java.util.ArrayList;
import java.util.List;

public class binary_tree_zigzag_level_order_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	zigzagLevelOrder(root, ret, 0);
    	
    	return ret;
    }
    
    public void zigzagLevelOrder(TreeNode root, List<List<Integer>> ret, int level) {
    	if(root == null) return;
    	
    	if(ret.size() < level + 1) ret.add(new ArrayList<>());
    	
    	
    	if(level % 2 == 0) {
        	ret.get(level).add(root.val);
    	} else {
        	ret.get(level).add(0, root.val);
    	}
    	
    	zigzagLevelOrder(root.left, ret, level + 1);	
		zigzagLevelOrder(root.right, ret, level + 1);
    	
    }
}
