package top_interview_medium.linked_list;

public class add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode( (l1.val + l2.val) % 10);
        
        ListNode pointer = head;
        
        int plusOne = (l1.val + l2.val) / 10;
        System.out.println(plusOne);
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null || l2 != null) {
        	ListNode temp = null;
        	if(l1 != null && l2 != null) {
        		temp = new ListNode((plusOne + l1.val + l2.val) % 10);
        		plusOne = (l1.val + l2.val + plusOne) / 10;
            	l1 = l1.next;
            	l2 = l2.next;
        	} else if(l1 != null) {
        		temp = new ListNode((plusOne + l1.val) % 10);
        		plusOne = (l1.val + plusOne) / 10;
        		l1 = l1.next;
        	} else if(l2 != null) {
        		temp = new ListNode((plusOne + l2.val) % 10);
        		plusOne = (l2.val + plusOne) / 10;
            	l2 = l2.next;
        	}
        	
        	pointer.next = temp;
        	pointer = temp;
        }
        
        if(plusOne == 1) {
        	pointer.next = new ListNode(1);
        }
        
        
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}