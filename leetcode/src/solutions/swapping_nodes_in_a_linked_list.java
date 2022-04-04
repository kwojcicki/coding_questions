package solutions;

public class swapping_nodes_in_a_linked_list {

    public ListNode swapNodes(ListNode head, int k) {
        int length = length(head);
        
        ListNode fromLeft = head;
        ListNode fromRight = head;
        
        for(int i = 1; i < k; i++) {
        	fromLeft = fromLeft.next;
        }
        
        for(int i = 1; i <= length - k; i++) {
        	fromRight = fromRight.next;
        }
        
        int tmp = fromLeft.val;
        fromLeft.val = fromRight.val;
        fromRight.val = tmp;
        
        return head;
    }
    
    public int length(ListNode head) {
    	if(head == null) return 0;
    	return 1 + length(head.next);
    }
}
