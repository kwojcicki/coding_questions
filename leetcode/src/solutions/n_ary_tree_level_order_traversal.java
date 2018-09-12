package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n_ary_tree_level_order_traversal {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> toRet = new ArrayList<List<Integer>>();
		
        if (root == null) {
            return toRet;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node nei : node.children) {
                    queue.offer(nei);
                }
            }
            toRet.add(list);
        }
		
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


