package solutions;

public class add_two_numbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tmp = head;

		int carry = 0;
		while(l1 != null || l2 != null || carry > 0) {
			int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);

			if(sum >= 10) {
				carry = 1;
				sum -=10;
			} else {
				carry = 0;
			}

			tmp.next = new ListNode(sum);
			tmp = tmp.next;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}

		return head.next;
	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		int value = 0;
		int remainder = 0;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0){
			value = carry;
			if(l1 != null){
				value += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				value += l2.val;
				l2 = l2.next;
			}
			remainder = value % 10;
			carry = value / 10;
			curr.next = new ListNode(remainder);
			curr = curr.next;
		}

		return head.next;
	}
}

/**
 * Definition for singly-linked list.
 * */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
}
