package top_interview_easy.linked_list;

public class merge_two_sorted {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
        	return null;
        } else if(l1 == null) {
        	return l2;
        } else if(l2 == null) {
        	return l1;
        }
        
        if(l1.val < l2.val) {
        	l1.next = mergeTwoLists(l1.next, l2);
        	return l1;
        } else {
        	l2.next = mergeTwoLists(l1, l2.next);
        	return l2;
        }
        
    }
    
}
