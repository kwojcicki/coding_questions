package solutions;

import java.util.ArrayList;
import java.util.List;

public class leaf_similar_trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == root2 && root1 == null) return true;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(root1, list1);
        helper(root2, list2);
        return list1.equals(list2);
    }
    
    public void helper(TreeNode root, List<Integer> l) {
    	if(root == null) return;
    	if(root.left == null && root.right == null) l.add(root.val);
    	else {
    		helper(root.left, l);
    		helper(root.right, l);
    	}
    }
}
