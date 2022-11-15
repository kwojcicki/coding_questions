package solutions;

public class count_complete_tree_nodes {
	public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1;
        int count = 1;
        while(root != null && root.left != null){
            int l = height(root.left);
            int r = height(root.right);

            if(l == r){
                root = root.right;
                count += (1 << l);
            } else {
                root = root.left;
                count += (1 << (l - 1));
            }
        }
        return count;
    }
}
