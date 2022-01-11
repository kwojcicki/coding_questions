package solutions;

public class sum_of_root_to_leaf_binary_numbers {
	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	public int sumRootToLeaf(TreeNode root, int curr) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return (curr << 1) + root.val;
		}

		return sumRootToLeaf(root.left, (curr << 1) + root.val) + 
				sumRootToLeaf(root.right, (curr << 1) + root.val);
	}

	
    public int sumRootToLeaf1(TreeNode root) {
    	return sumToRootLeaf1(root, 0);
    }
    
    public int sumToRootLeaf1(TreeNode root, int curr) {
    	if(root == null) {
    		return 0;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return curr * 2 + root.val;
    	}
    	
    	return sumToRootLeaf1(root.left, curr * 2 + root.val) + sumToRootLeaf1(root.right, curr * 2 + root.val); 
    	
    }
	
}
