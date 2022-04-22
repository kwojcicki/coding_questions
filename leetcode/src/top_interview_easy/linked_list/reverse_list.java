package top_interview_easy.linked_list;

public class reverse_list {

    public ListNode reverseList(ListNode head) {
    	return helper(head, null);
    }
    
    public ListNode helper(ListNode head, ListNode newHead) {
    	if(head == null) {
    		return newHead;
    	}
    	
    	ListNode next = head.next;
    	head.next = newHead;
    	
    	return helper(next, head);
    }
    
    public ListNode reverseList1(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	
        ListNode tail = new ListNode(head.val);
        ListNode newHead = tail;
    	head = head.next;
        
        while(head != null) {
        	ListNode temp = new ListNode(head.val);
        	temp.next = newHead;
        	newHead = temp;
        	head = head.next;
        }
        
        return newHead;
    }
    
}
