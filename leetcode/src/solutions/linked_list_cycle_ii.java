package solutions;

public class linked_list_cycle_ii {
	public ListNode detectCycle(ListNode head) {

		if(head == null || head.next == null) return null;

		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) break;
		}

		// System.out.println(fast.val + " " + slow.val);

		if(fast == null || fast.next == null) return null;

		fast = head;

		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}
}
