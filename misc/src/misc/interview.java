package misc;

import java.util.HashMap;
import java.util.Map;

public class interview {

	/**
	 * 
	 *  Given list that looks like following
	 *  
	 *  [] -> [] -> [] -> [] -> []
	 *  |     ^      ^     |
	 *   -----|      |-----|
	 *   
	 *   Create method that can deep copy structures like this
	 */
	public static void main(String[] args) {
		
	}
	
	public static Node deepCopy(Node x) {
		
		Node oldHead = x;
		
		Node head = new Node(x.val);
		Node newHead = head;
		Map<Node, Node> seen = new HashMap<Node, Node>();
		seen.put(x, head);
		
		while(x.next != null) {
			Node newNode = new Node(x.next.val);
			seen.put(x.next, newNode);
			head.next = newNode;
			head = head.next;
		}
		
		
	}
	
	static class Node {
		int val;
		Node next;
		Node optional;
		public Node(int x) { val = x; }
	}
}
