package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class clone_graph {
	public Node cloneGraph(Node node) {
		if(node == null) {
			return null;
		}

		Node newHead = new Node(node.val);
		Map<Integer, Node> newNodes = new HashMap<Integer, Node>();
		newNodes.put(1, newHead);

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while(!q.isEmpty()) {
			Node root = q.poll();

			for(Node n: root.neighbors) {
				if(!newNodes.containsKey(n.val)) newNodes.put(n.val, new Node(n.val));

				if(n.neighbors.size() == newNodes.get(n.val).neighbors.size() ) continue;

				if(n.val > root.val) { 
					q.add(n);
					newNodes.get(root.val).neighbors.add(newNodes.get(n.val));
					newNodes.get(n.val).neighbors.add(newNodes.get(root.val));
				}
			}

		}



		return newHead;
	}
}
