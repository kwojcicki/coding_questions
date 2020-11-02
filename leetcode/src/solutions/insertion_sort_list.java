package solutions;

public class insertion_sort_list {
	public ListNode insertionSortList(ListNode head) {
		if(head == null) {
			return head;
		}

		ListNode newHead = head;

		ListNode ptr = head.next;

		newHead.next = null;

		while(ptr != null) {
			// System.out.println(ptr.val);
			if(ptr.val < newHead.val) {
				ListNode tmp = ptr;
				ptr = ptr.next;
				tmp.next = newHead;
				newHead = tmp;
			} else {

				ListNode tmp = newHead.next;
				ListNode prev = newHead;
				while(tmp != null && ptr.val > tmp.val) {
					prev = tmp;
					tmp = tmp.next;
				}

				if(tmp == null) {
					prev.next = ptr;
				} else {
					prev.next = ptr;
				}

				ptr = ptr.next;
				prev.next.next = tmp;
			}
		}

		return newHead;
	}
}
