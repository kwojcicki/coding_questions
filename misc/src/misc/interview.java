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
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		n1.optional = n3;
		System.out.println("before: ");
		printList(n1);
		Node newList = deepCopy(n1);
		System.out.println("after: ");
		printList(newList);
		
	}
	
	public static void printList(Node head) {
		System.out.println("Node: " + head + " val: " + head.val + " next: " + head.next + " optional: " + head.optional);
		if(head.next != null) {
			printList(head.next);
		}
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
			x = x.next;
		}
		
		while(oldHead.next != null) {
			if(oldHead.optional != null) {
				seen.get(oldHead).optional = seen.get(oldHead.optional);
			}
			oldHead = oldHead.next;
		}
		
		return newHead;
	}
	
	static class Node {
		int val;
		Node next;
		Node optional;
		public Node(int x) { val = x; }
	}
}
