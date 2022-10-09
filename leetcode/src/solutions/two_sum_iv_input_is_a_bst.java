package solutions;

import java.util.HashSet;
import java.util.Set;

public class two_sum_iv_input_is_a_bst {
    public boolean findTarget(TreeNode root, int k) {
    	return helper(root, k, new HashSet<Integer>());
    }
    
    public boolean helper(TreeNode root, int k, Set<Integer> s) {
    	if(root == null) return false;
    	
    	if(s.contains(k - root.val)) return true;
    	s.add(root.val);
    	
    	return helper(root.left, k, s) || helper(root.right, k, s);
    }
}
