package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class clone_graph {
	
    public Node cloneGraph(Node node) {
        if(node == null) {
        	return node;
        }
        
        Map<Integer, Node> map = new HashMap<>();
        recurse(node, map);
        
        return map.get(node.val);
    }
	
	public Node recurse(Node node, Map<Integer, Node> map) {
		Node clone = new Node(node.val);
		map.put(node.val, clone);
		
		for(Node n: node.neighbors) {
			if(map.containsKey(n.val)) {
				clone.neighbors.add(map.get(n.val));
			} else {
				Node cl = recurse(n, map);
				clone.neighbors.add(cl);
			}
		}
		
		return clone;
	}
	
	public Node cloneGraph1(Node node) {
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
	
	public static void helper(char[] chars, int index, StringBuilder curr, List<String> ret, int n) {
		if(curr.length() == n) {
			String temp = curr.toString();
			//System.out.println(temp);
			if(temp.contains("aa")  || temp.contains("aba")) return;
			ret.add(curr.toString());
			return;
		}
		
		for(int i = 0; i < chars.length; i++) {
			curr.append(chars[i]);
			helper(chars, i, curr, ret, n);
			curr.setLength(curr.length() - 1);
		}
	}
	
	public static void main(String[] args) {
//		char[] poss = new char[] {'a', 'b', 'c'};
//		List<String> x = new ArrayList<>();
//		for(int i = 4; i < 10; i++) {
//			x = new ArrayList<>();
//			System.out.println("i: " + i);
//			helper(poss, 0, new StringBuilder(), x, i);
//			System.out.println(x);
//			System.out.println(x.size());	
//		}
	}
}
