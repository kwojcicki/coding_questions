package solutions;

public class deepest_leaves_sum {
	
	class Pair {
		int height;
		int value;
		public Pair(int height, int value) {
			this.height = height;
			this.value = value;
		}
	}
	
    public int deepestLeavesSum(TreeNode root) {
        return helper(root, 0).value;
    }
    
    public Pair helper(TreeNode root, int height) {
    	if(root == null) {
    		return null;
    	}
    	
    	if(root.left == null && root.right == null) {
    		return new Pair(height, root.val);
    	}
    	
    	Pair left = helper(root.left, height + 1);
    	Pair right = helper(root.right, height + 1);
    	
    	if(left == null) {
    		return right;
    	} else if(right == null) {
    		return left;
    	}
    	
    	if(left.height == right.height) {
    		return new Pair(left.height, left.value + right.value);
    	}
    	
    	return left.height > right.height ? left : right;
    }
}
