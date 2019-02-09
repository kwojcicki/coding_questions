package top_interview_easy.linked_list;

public class linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
        	return false;
        }
        
        ListNode slower = head.next;
        if(slower == null) {
        	return false;
        }
        
        ListNode faster = slower.next;
        if(faster == null) {
        	return false;
        }
        
        while(slower != faster) {
        	
        	slower = slower.next;
        	
        	faster = faster.next;
        	if(faster == null) {
        		return false;
        	}
        	
        	faster = faster.next;
        	if(faster == null) {
        		return false;
        	}
        	
        }
        
        return true;
    }
}
