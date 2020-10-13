package solutions;

public class sort_list {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return mergeLists(left, right);
	}

	public ListNode mergeLists(ListNode left, ListNode right){
		ListNode dummy = new ListNode();

		ListNode tmp = dummy;

		while(left != null && right != null){
			if(left.val < right.val){
				tmp.next = left;
				tmp = tmp.next;
				left = left.next;
			} else {
				tmp.next = right;
				tmp = tmp.next;
				right = right.next;
			}
		}

		tmp.next = (left == null ? right : left);

		return dummy.next;
	}

	public ListNode getMid(ListNode head){
		ListNode fast = head, slow = head, midPrev = null;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			midPrev = slow;
			slow = slow.next;
		}

		midPrev.next = null;
		return slow;
	}
}
