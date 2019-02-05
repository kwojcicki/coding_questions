package top_interview_medium.linked_list;

public class odd_even_linked_list {
	public ListNode oddEvenList(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		ListNode oldEven = head.next;

		ListNode odd = head;
		ListNode even = head.next;

		while(true) {
			odd.next = even.next;
			
			if(even.next == null) {
				odd.next = oldEven;
				break;
			}
			
			odd = odd.next;

			even.next = odd.next;
			
			if(odd.next == null) {
				odd.next = oldEven;
				break;
			}
			
			even = even.next;
		}

		return head;
	}
}