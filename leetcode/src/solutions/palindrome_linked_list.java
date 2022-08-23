package solutions;

public class palindrome_linked_list {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;

		new palindrome_linked_list().isPalindrome(one);

		one = new ListNode(1);
		two = new ListNode(2);
		one.next = two;
		three = new ListNode(3);
		two.next = three;
		four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(5);
		four.next = five;

		new palindrome_linked_list().isPalindrome(one);
	}

	public boolean isPalindrome(ListNode head) {
		ListNode fst = head;
		ListNode slw = head;
		ListNode prev = null;
		ListNode tmp = null;
		boolean even = false;
		while(fst != null) {
			fst = fst.next;

			tmp = slw.next;
			slw.next = prev;
			prev = slw;
			slw = tmp;

			if(fst == null) {
				even = true;
				break;
			}

			fst = fst.next;
		}

		// System.out.println(slw.val + " " + slw.next.val + " " + even);
		if(even) {
			fst = prev.next;
		} else {
			fst = prev;
		}

		while(fst != slw) {
			// System.out.println(slw.val + " " + fst.val + " " + even);
			if(fst.val != slw.val) return false;
			fst = fst.next;
			if(fst == slw) break;
			slw = slw.next;
		}

		return true;
	}

	public boolean isPalindrome1(ListNode head) {
		int length = length(head);

		ListNode tail = reverse(head, (int) Math.ceil(length / 2.0));

		while(tail != head) {
			// System.out.println(tail.val + " " + head.val);
			if(tail.val != head.val) return false;
			tail = tail.next;
			if(tail == head) break;
			head = head.next;
		}

		return true;
	}

	public int length(ListNode head) {
		return head == null ? 0 : 1 + length(head.next);
	}

	public ListNode reverse(ListNode head, int mid) {
		for(int i = 0; i < mid - 1; i++) {
			head = head.next;
		}

		ListNode prev = head;
		head = head.next;
		ListNode tmp;

		while(head != null) {
			tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}

		return prev;
	}
}
