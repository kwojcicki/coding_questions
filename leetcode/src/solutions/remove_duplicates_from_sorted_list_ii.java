package solutions;

public class remove_duplicates_from_sorted_list_ii {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;

		while(head != null) {

			if(head.next != null && head.next.val == head.val) {
				int tmp = head.val;
				while(head != null && head.val == tmp) {
					head = head.next;
				}
			} else {
				ptr.next = head;
				head = head.next;
				ptr = ptr.next;
			}

		}

		ptr.next = null;
		return dummy.next;
	}
}
