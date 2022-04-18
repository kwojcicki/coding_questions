package solutions;

public class reverse_nodes_in_k_group {
    public ListNode reverseKGroup(ListNode head, int k) {
        int tmpK = k;
        
        ListNode tmp = head;
        int count = 0;
        while(tmp != null && count < k) {
        	tmp = tmp.next;
        	count++;
        }
        
        if(count < k) return head;
        
        ListNode dummy = new ListNode(-1);
        tmp = dummy;
        tmp.next = head;
        
        while(k != 0) {
        	ListNode t = head.next.next;
        	tmp.next = head.next;
        	head.next = t;
        	head = head.next;
        }
        
        head.next = reverseKGroup(head, tmpK);
        return dummy.next;
    }
}
