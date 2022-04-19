package solutions;

import java.util.ArrayList;
import java.util.List;

public class binary_tree_inorder_traversal {


	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();

		TreeNode curr = root, prev = null;

		while(curr != null) {

			if(curr.left == null) {
				ret.add(curr.val);
				curr = curr.right;
			} else {
				prev = curr.left;

				while(prev.right != null && prev.right != curr)
					prev = prev.right;

				if(prev.right == null) {
					prev.right = curr;	
					curr = curr.left;
				} else {
					prev.right = null;
					ret.add(curr.val);
					curr = curr.right;
				}
			}
		}

		return ret;
	}

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		recursive(root, ret);
		return ret;
	}

	public void recursive(TreeNode root, List<Integer> ret) {
		if(root == null) {
			return;
		}

		recursive(root.left, ret);
		ret.add(root.val);
		recursive(root.right, ret);
	}
}
