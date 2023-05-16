package solutions;

public class swap_nodes_in_pairs {
	
    public ListNode swapPairsRecursive(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode ret = head.next;
        head.next = head.next.next;
        ret.next = head;

        head.next = swapPairsRecursive(head.next);
        
        return ret;
    }
    
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
