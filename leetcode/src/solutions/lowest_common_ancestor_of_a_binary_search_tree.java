package solutions;

public class lowest_common_ancestor_of_a_binary_search_tree {
	
	TreeNode lowest = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowest = root;
    	
        if(p.val >= q.val) {
        	TreeNode temp = q;
        	q = p;
        	p = temp;
        }
        
        recurse(root.left, p, q, Integer.MIN_VALUE, root.val);
        recurse(root.left, p, q, root.val, Integer.MAX_VALUE);
        
    	return lowest;
    }
    
    public void recurse(TreeNode root, TreeNode p, TreeNode q, int min, int max) {
    	if(root == null) return;
    	
    	if(p.val > min && q.val < max) lowest = root;
    	
    	recurse(root.left, p, q, min, root.val);
        recurse(root.left, p, q, root.val, max);
    }
}
