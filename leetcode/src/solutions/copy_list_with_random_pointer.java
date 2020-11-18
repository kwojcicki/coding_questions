package solutions;

import java.util.HashMap;
import java.util.Map;

public class copy_list_with_random_pointer {
    public Node copyRandomList(Node head) {
     
    	if(head == null) {
    		return null;
    	}
    	
    	Map<Node, Node> nodes = new HashMap<>(); // original -> copied
    	Node newHead = new Node(head.val);
    	
    	nodes.put(head, newHead);
    	
    	Node pointer = head.next;
    	Node newPointer = newHead;
    	while(pointer != null) {
    		Node newNode = new Node(pointer.val);
    		newPointer.next = newNode;
    		
    		nodes.put(pointer, newNode);
    		
    		pointer = pointer.next;
    		newPointer = newPointer.next;
    	}
    	
    	pointer = head;
    	newPointer = newHead;
    	while(pointer != null) {
    		newPointer.random = nodes.get(pointer.random);
    		
    		pointer = pointer.next;
    		newPointer = newPointer.next;
    	}
    	
    	
    	return newHead;
    }
}
