package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class vertical_order_traversal_of_a_binary_tree {

	int lowest = 0;
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(root, 0));

		while(!q.isEmpty()) {
			Map<Integer, Queue<Integer>> tmp = new HashMap<>();
			for(int i = q.size() - 1; i >= 0; i--) {
				Tuple n = q.poll();
				lowest = Math.min(lowest, n.col);
				tmp.putIfAbsent(n.col, new PriorityQueue<>());
				tmp.get(n.col).add(n.root.val);
				if(n.root.left != null) q.add(new Tuple(n.root.left, n.col - 1));
				if(n.root.right != null) q.add(new Tuple(n.root.right, n.col + 1));
			}

			for(Map.Entry<Integer, Queue<Integer>> record: tmp.entrySet()) {
				map.putIfAbsent(record.getKey(), new ArrayList<>());
				Queue<Integer> tmpQ = record.getValue();
				while(!tmpQ.isEmpty()) map.get(record.getKey()).add(tmpQ.poll());
			}
		}

		List<List<Integer>> ret = new ArrayList<>(map.size());
		for(int i = lowest; i < lowest + map.size(); i++) {
			ret.add(map.get(i));
		}

		return ret;
	}

	class Tuple {
		public int col;
		public TreeNode root;
		public Tuple(TreeNode root, int col) {
			this.root = root; this.col = col;
		}
	}
}
