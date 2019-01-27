package top_interview_easy.trees;

public class symmetric_tree {
    public boolean isValidBST(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	
        return allSmaller(root.left, root.val) && allBigger(root.right, root.val) &&
        		isValidBST(root.left) && isValidBST(root.right);
    }
    
    public boolean allSmaller(TreeNode root, int val) {
    	if(root == null) {
    		return true;
    	}
    	
    	if(root.val >= val) {
    		return false;
    	}
    	
    	return allSmaller(root.left, val) && allSmaller(root.right, val);
    }
    
    public boolean allBigger(TreeNode root, int val) {
    	if(root == null) {
    		return true;
    	}
    	
    	if(root.val <= val) {
    		return false;
    	}
    	
    	return allBigger(root.left, val) && allBigger(root.right, val);
    }
}
