package solutions;

public class add_two_numbers_ii {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		
		int n1 = length(l1);
		int n2 = length(l2);
		
		ListNode dummy = null;
		ListNode ptr = dummy;
		
		while(n1 > 0 || n2 > 0) {
			int val = 0;
			
			if(n1 > n2) {
				val += l1.val;
				n1--; l1 = l1.next;
			} else if(n2 > n1) {
				val += l2.val;
				n2--; l2 = l2.next;
			} else {
				val += l1.val + l2.val;
				n1--; n2--;
				l1 = l1.next; l2 = l2.next;
			}
			
			ListNode tmp = new ListNode(val);
			tmp.next = dummy;
            dummy = tmp;
		}
        
		ptr = dummy;
        dummy = null;
		int carry = 0;
		while(ptr != null || carry > 0) {
            int val = carry;
            if(ptr != null) val += ptr.val;
            carry = val / 10;
            ListNode curr = new ListNode(val % 10);
            
            curr.next = dummy;
            dummy = curr;
            if(ptr != null) ptr = ptr.next;
		}
		
		return dummy;
	}
	
	public int length(ListNode l) {
		int len = 0;
		while(l != null) {
			l = l.next;
			len++;
		}
		return len;
	}
	
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
       l1 = reverse(l1);
       l2 = reverse(l2);
       
       ListNode dummy = new ListNode();
       ListNode ptr = dummy;
       int carry = 0;
       while(l1 != null || l2 != null || carry > 0) {

		   ListNode tmp = new ListNode();
		   
		   int sum = carry;
		   if(l1 != null) sum += l1.val;
		   if(l2 != null) sum += l2.val;
		   //int sum = l1.val + l2.val + carry;
		   if(sum > 9) {
			   tmp.val = 9;
			   carry = sum - 9;
		   } else {
			   tmp.val = sum;
			   carry = 0;
		   }
		   
		   ptr.next = tmp;
		   ptr = tmp;
       }
       
       return dummy.next;
    }
    
    public ListNode reverse(ListNode l) {
    	ListNode dummy = new ListNode();
    	
    	while(l != null) {
    		ListNode tmp = l.next;
    		l.next = dummy.next;
    		dummy.next = l;
    		l = tmp;
    	}
    	
    	return dummy.next;
    }
}
