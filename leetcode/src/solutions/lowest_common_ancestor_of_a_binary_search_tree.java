package solutions;

public class lowest_common_ancestor_of_a_binary_search_tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
	
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public TreeNode helper(TreeNode root, 
			TreeNode p, 
			TreeNode q, 
			Integer min, 
			Integer max) {
		if(root == null) return null;

		if(root == p || root == q) return root;

		if(!(inRange(p.val, min, root.val) &&
				inRange(q.val, min, root.val)) &&
				!(inRange(p.val, root.val, max) &&
						inRange(q.val, root.val, max))) {
			return root;
		}

		if(inRange(p.val, min, root.val)) return helper(root.left, p, q, min, root.val);
		
		return helper(root.right, p, q, root.val, max);
	}

	public boolean inRange(int x, int start, int end) {
		return x >= start && x <= end;
	}

	TreeNode lowest = null;
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		lowest = root;

		if(p.val >= q.val) {
			TreeNode temp = q;
			q = p;
			p = temp;
		}

		recurse(root.left, p, q, Integer.MIN_VALUE, root.val);
		recurse(root.right, p, q, root.val, Integer.MAX_VALUE);

		return lowest;
	}

	public void recurse(TreeNode root, TreeNode p, TreeNode q, int min, int max) {
		if(root == null) return;

		if(p.val > min && q.val < max) lowest = root;

		recurse(root.left, p, q, min, root.val);
		recurse(root.right, p, q, root.val, max);
	}
}
