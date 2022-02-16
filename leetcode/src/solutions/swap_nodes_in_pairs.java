package solutions;

public class swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
    		return null;
    	}
    	
        ListNode newHead = new ListNode();
        ListNode tmp = newHead;
        
        while(head != null && head.next != null) {
        	tmp.next = head.next;
        	head.next = head.next.next;
        	tmp.next.next = head;
        	
        	tmp = head;
        	head = head.next;
        }
        
        if(head != null){
            tmp.next = head;
        }
        
        return newHead.next;
    }
}
