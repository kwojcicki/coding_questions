package solutions;

import java.util.ArrayList;
import java.util.List;

public class n_ary_tree_preorder_traversal {
	public List<Integer> preorder(Node root) {
		List<Integer> l = new ArrayList<Integer>();
		if(root == null) {
			return l;
		}
		l.add(root.val);
		for(Node c : root.children) {
			l.addAll(preorder(c));
		}
		return l;
	}
}

//Definition for a Node.
class Node {
	public int val;
	public List<Node> children;
	Node next;
	Node random;
	public Node parent;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	public Node() {}

	public Node(int _val,List<Node> _children) {
		val = _val;
		children = _children;
	}
}
