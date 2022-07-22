package solutions;

public class partition_list {

    public ListNode partition(ListNode head, int x) {
    	ListNode lowerHead = new ListNode(0);
        ListNode lowerCurr = lowerHead;
        ListNode upperHead = new ListNode(0);
        ListNode upperCurr = upperHead;
        
        while(head != null) {
        	if(head.val < x) {
        		lowerCurr.next = head;
        		lowerCurr = lowerCurr.next;
        	} else {
        		upperCurr.next = head;
        		upperCurr = upperCurr.next;
        	}
    		head = head.next;
        }
        
        upperCurr.next = null;
        lowerCurr.next = upperHead.next;
        return lowerHead.next;
    }
}
