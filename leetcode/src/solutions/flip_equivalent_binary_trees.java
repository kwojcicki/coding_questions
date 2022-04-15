package solutions;

public class flip_equivalent_binary_trees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == root2 && root1 == null) {
        	return true;
        } else if(root1 == null || root2 == null) {
        	return false;
        }
        
        if(root1.val == root2.val) {
        	return ( flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ) ||
        			( flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right) );
        }
        
        return false;
    }
}
