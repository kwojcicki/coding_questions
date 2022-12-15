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
	public Node next;
    public Node random;
    public Node parent;
    public Node left;
    public Node right;
    public List<Node> neighbors;

	public Node() {}

	public Node(int _val,List<Node> _children) {
		val = _val;
		children = _children;
	}

	public Node(int val2) {
		this.val = val2;
		next = null;
		random = null;
	}
}
