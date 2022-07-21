package solutions;

public class reverse_linked_list_ii {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(head.next == null) return head;

		ListNode prev = head;
		for(int i = 1; i < left - 1; i++) prev = prev.next;
		if(left == 1) { prev = new ListNode(3); prev.next = head; }

		ListNode tmp = null;
		ListNode curr = prev.next;
		ListNode copy = prev.next;
		ListNode t = null;
		for(int i = 0; i < right - left + 1; i++) {
			t = curr.next;
			curr.next = tmp;
			tmp = curr;
			curr = t;
		}

		prev.next = tmp;
		copy.next = t;

		if(left == 1) return prev.next;
		return head;
	}
}
