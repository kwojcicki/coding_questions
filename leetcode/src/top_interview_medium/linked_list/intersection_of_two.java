package top_interview_medium.linked_list;

public class intersection_of_two {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    	ListNode a = headA;
    	ListNode b = headB;
    	
    	while( a != b) {
    		if(a == null) {
    			a = headB;
    		} else {
    			a = a.next;
    		}
    		
    		if(b == null) {
    			b = headA;
    		} else {
    			b = b.next;
    		}
    	}
    	
    	return a;
    }
}
