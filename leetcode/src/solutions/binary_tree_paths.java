package solutions;

class binary_tree_paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        recurse(root, "", ret);
        return ret;
    }
    
    public void recurse(TreeNode root, String curr, List<String> ret){
        if(root == null) return;
        
        curr = curr.length() == 0 ? root.val + "" : curr + "->" + root.val;
        if(root.left == null && root.right == null) ret.add(curr);
        recurse(root.left, curr, ret);
        recurse(root.right, curr, ret);
    }
}
