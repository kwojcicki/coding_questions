package solutions;

public class delete_the_middle_node_of_a_linked_list {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
        	return null;
        }
        
        ListNode fst = head;
        ListNode prev  = null;
        ListNode slw = head;
        
        while(fst != null && fst.next != null) {
        	fst = fst.next.next;
        	prev = slw;
        	slw = slw.next;
        }
        
        prev.next = slw.next;
        
        return head;
    }
}
