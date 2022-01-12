package solutions;

public class insert_into_a_binary_search_tree {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}

		helper(root, new TreeNode(val));
		return root;
	}

	public void helper(TreeNode root, TreeNode toInsert) {
		if(root.val > toInsert.val) {
			if(root.left == null) {
				root.left = toInsert;
				return;    			
			}

			helper(root.left, toInsert);
		} else if(root.val < toInsert.val) {
			if(root.right == null) {
				root.right = toInsert;
				return;
			}
			helper(root.right, toInsert);
		}
	}

	public TreeNode insertIntoBST1(TreeNode root, int val) {
		if(root == null) return new TreeNode(val);

		recurse(root, new TreeNode(val));

		return root;
	}

	public void recurse(TreeNode root, TreeNode insert) {

		if(insert.val > root.val) {

			if(root.right == null) {
				root.right = insert;
				return;
			}

			recurse(root.right, insert);

		} else {

			if(root.left == null) {
				root.left = insert;
				return;
			}

			recurse(root.left, insert);

		}
	}
}
