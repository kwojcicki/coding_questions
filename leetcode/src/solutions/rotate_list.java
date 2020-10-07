package solutions;

public class rotate_list {

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) return null;

		int listSize = size(head);
		int rotate = k % listSize;

		if(rotate == 0) return head;

		ListNode oldHead = head;

		for(int i = listSize; i > rotate + 1; i--) {
			head = head.next;
		}

		ListNode newHead = head.next;
		ListNode temp = newHead;
		//System.out.println(listSize + " " + rotate + " " + newHead);
		head.next = null;

		while(temp.next != null) {
			temp = temp.next;
		}

		temp.next = oldHead;

		return newHead;
	}

	public int size(ListNode head) {
		if(head == null) return 0;

		return 1 + size(head.next);
	}
}
