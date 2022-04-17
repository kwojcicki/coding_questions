package solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_search_tree_iterator_ii {
	class BSTIterator {

		int pointer = -1;
		TreeNode root;
		Deque<TreeNode> s = new ArrayDeque<>();
		List<Integer> list = new LinkedList<>();

		public BSTIterator(TreeNode root) {
			this.root = root;
		}

		public boolean hasNext() {
			return pointer < list.size() || !s.isEmpty();
		}

		public int next() {
			pointer++;
			if(pointer >= list.size()) {
				while(root != null) {
					s.add(root);
					root = root.left;
				}

				TreeNode curr = s.pollLast();
				root = curr.right;
				// System.out.println("Adding: " + curr.val + " " + s.peek().val);
				list.add(curr.val);
			}
			
			return list.get(pointer);
		}

		public boolean hasPrev() {
			return pointer > 0;
		}

		public int prev() {
			pointer--;
			return list.get(pointer);
		}
	}
	
	public static void main(String[] args) {
		TreeNode seven = new TreeNode(7);
		TreeNode three = new TreeNode(3);
		TreeNode fifteen = new TreeNode(15);
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		
		seven.left = three;
		seven.right = fifteen;
		
		fifteen.left = nine;
		fifteen.right = twenty;
		
		binary_search_tree_iterator_ii y = new binary_search_tree_iterator_ii();
		BSTIterator x = y.new BSTIterator(seven);
		
		System.out.println(x.next());
		System.out.println(x.next());
		System.out.println(x.prev());
		System.out.println(x.next());
		System.out.println(x.hasNext());
		System.out.println(x.next());
		System.out.println(x.next());
		System.out.println(x.next());
		System.out.println(x.hasNext());
		System.out.println(x.hasPrev());
		System.out.println(x.prev());
		System.out.println(x.prev());
	}
}
