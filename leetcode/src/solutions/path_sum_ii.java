package solutions;

import java.util.ArrayList;
import java.util.List;

public class path_sum_ii {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(root, 0, targetSum, ret, new ArrayList<>());
        return ret;
    }
    
    public void helper(TreeNode root, int currSum, int targetSum, List<List<Integer>> ret, List<Integer> curr) {
    	if(root == null) return;
    	currSum += root.val;
		curr.add(root.val);
		
    	if(root.left == null && root.right == null && targetSum == currSum) {
    		ret.add(new ArrayList<>(curr));
    		curr.remove(curr.size() - 1);
    		return;
    	}
    	
    	helper(root.left, currSum, targetSum, ret, curr);
    	helper(root.right, currSum, targetSum, ret, curr);
    	curr.remove(curr.size() - 1);
    }
}
