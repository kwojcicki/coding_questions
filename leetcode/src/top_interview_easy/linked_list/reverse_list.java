package top_interview_easy.linked_list;

public class reverse_list {
	
    public ListNode reverseList(ListNode head) {
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
