package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class recover_binary_search_tree {

	public void recoverTree(TreeNode root) {
		if(root == null) return;

		TreeNode curr = root, prev = null, x = null, y = null, p = null;

		while(curr != null) {
			if(curr.left == null) {
				if(p != null && p.val > curr.val) {
					y = curr;
					if(x == null) x = p;
				}
				p = curr;
				curr = curr.right;
			} else {
				prev = curr.left;

				while(prev.right != null && prev.right != curr) prev = prev.right;

				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				} else {
					prev.right = null;
					if(p != null && p.val > curr.val) {
						y = curr;
						if(x == null) x = p;
					}
					p = curr;
					curr = curr.right;
				}
			}
		}

		int tmp = x.val;
		x.val = y.val;
		y.val = tmp;
	}

	public void recoverTree1(TreeNode root) {

		TreeNode x = null, y = null, prev = null;

		Deque<TreeNode> s = new LinkedList<>();

		while(!s.isEmpty() || root != null) {
			while(root != null) {
				s.add(root);
				root = root.left;
			}

			root = s.pollLast();

			if(prev != null && root.val < prev.val) {
				y = root;
				if(x == null) x = prev;
				else break;
			}

			prev = root;
			root = root.right;
		}

		if(x != null) {
			int tmp = x.val;
			x.val = y.val;
			y.val = tmp;
		}
	}
}
