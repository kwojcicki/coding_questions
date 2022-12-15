package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class maximum_width_of_binary_tree {
	
	public int widthOfBinaryTree(TreeNode root) {
		int ret = 0;

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(1, root));

		while(!q.isEmpty()) {
			long left = 0, right = q.peek().n;

			for(int i = q.size(); i > 0; i--) {
				Pair n = q.poll();
				long idx = n.n - right;
				
				left = Math.max(left, n.n);
				if(n.node.left != null) q.add(new Pair(idx * 2, n.node.left));
				if(n.node.right != null) q.add(new Pair(idx * 2 + 1, n.node.right));
			}

			if(left != 0)
				ret = (int) Math.max(ret, left - right + 1);
		}

		return ret;
	}

	class Pair {
		long n;
		TreeNode node;
		public Pair(long n, TreeNode node) {
			this.n = n; this.node = node;
		}
	}
}
