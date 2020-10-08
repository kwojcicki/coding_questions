package solutions;

public class remove_nth_node_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        if(head.next == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 0; i < n; i++) {
        	fast = fast.next;
        }
        
        if(fast == null) return head.next;
        
        while(fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
