package solutions;

public class middle_of_the_linked_list {
	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}
