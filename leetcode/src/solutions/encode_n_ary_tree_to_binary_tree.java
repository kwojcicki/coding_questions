package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class encode_n_ary_tree_to_binary_tree {

	class Pair<U, V> {
		public U first;
		public V second;

		public Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}

	class Codec {
		// Encodes an n-ary tree to a binary tree.
		public TreeNode encode(Node root) {
			if(root == null) {
				return null;
			}

			TreeNode r = new TreeNode(root.val);

			Queue<Pair<TreeNode, Node>> q = new LinkedList<>();
			q.add(new Pair<>(r, root));

			while(!q.isEmpty()) {
				TreeNode temp = q.peek().first;
				Node t = q.poll().second;

				TreeNode prev = null, head = null;
				for(Node c: t.children) {
					TreeNode newNode = new TreeNode(c.val);
					if(prev == null) {
						head = newNode;
					} else {
						prev.right = newNode;
					}

					prev = newNode;
					q.add(new Pair<>(newNode, c));
				}

				temp.left = head;
			}

			return r;
		}

		// Decodes your binary tree to an n-ary tree.
		public Node decode(TreeNode root) {
			if(root == null) {
				return null;
			}

			Node r = new Node(root.val, new ArrayList<>());

			Queue<Pair<TreeNode, Node>> q = new LinkedList<>();
			q.add(new Pair<>(root, r));

			while(!q.isEmpty()) {
				TreeNode temp = q.peek().first;
				Node t = q.poll().second;


				TreeNode firstChild = temp.left;
				TreeNode sibling = firstChild;
				while (sibling != null) {
					Node nChild = new Node(sibling.val, new ArrayList<Node>());
					t.children.add(nChild);

					q.add(new Pair<>(sibling, nChild));

					sibling = sibling.right;
				}

			}

			return r;
		}
	}
}
