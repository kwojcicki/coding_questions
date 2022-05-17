package solutions;

public class find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == target) return cloned;
        
        if(original == null) return null;
        
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        return left != null ? left : getTargetCopy(original.right, cloned.right, target);
    }
}
