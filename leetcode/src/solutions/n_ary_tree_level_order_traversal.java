package solutions;

import java.util.List;

public class n_ary_tree_level_order_traversal {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> toRet = new List<List<Integer>>();
		
		return toRet;
	}

	//Definition for a Node.
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val,List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

}


