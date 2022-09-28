package solutions;

public class remove_duplicates_from_sorted_list {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;

		ListNode tmp = head;
		while(tmp.next != null) {
			if(tmp.next.val == tmp.val) {
				tmp.next = tmp.next.next;
			} else {
				tmp = tmp.next;
			}
		}

		return head;
	}
}
