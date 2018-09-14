package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binary_tree_level_order_traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
		
		if(root == null) {
			return toReturn;
		}
		
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			int size = nodes.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				TreeNode node = nodes.poll();
				if(node.left != null) {
					nodes.add(node.left);
				}
				if(node.right != null) {
					nodes.add(node.right);
				}
				list.add(node.val);
			}
			toReturn.add(list);
		}
		
		return toReturn;
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}