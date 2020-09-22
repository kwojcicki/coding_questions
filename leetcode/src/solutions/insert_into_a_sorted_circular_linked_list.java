package solutions;

public class insert_into_a_sorted_circular_linked_list {
    public Node insert(Node head, int insertVal) {
        
    	Node ptr = head;
    	
    	if(ptr == null) {
    		Node n = new Node(insertVal);
    		n.next = n;
    		return n;
    	}
    	
    	do {
    		
    		if(ptr.next.val >= insertVal && ptr.val < insertVal) {
    			Node n = new Node(insertVal);
    			n.next = ptr.next;
    			ptr.next = n;
    			return head;
    		}
    		
    		ptr = ptr.next;
    		
    	} while(ptr != head);
    	
        
    	Node max = ptr;
    	do {
    		if(ptr.val >= max.val) max = ptr;
            
            ptr = ptr.next;
    	} while(ptr != head);
    	
    	Node n = new Node(insertVal);
    	n.next = max.next;
    	max.next = n;
    	
    	return head;
    }
}
