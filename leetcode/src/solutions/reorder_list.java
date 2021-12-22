package solutions;

public class reorder_list {

	public void reorderList(ListNode head) {
		if(head == null) return;

		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode curr = slow;
		ListNode prev = null;
		ListNode tmp;
		while(curr != null) {
			tmp = curr.next;

			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		ListNode first = head;
		ListNode second = prev;

		while(second.next != null) {
			tmp = first.next;
			first.next = second;
			first = tmp;

			tmp = second.next;
			second.next = first;
			second = tmp;
		}

	}

	public void reorderList1(ListNode head) {
		int size = length(head);
		if(size == 0 || size == 1 || size == 2) return;

		ListNode temp = head;
		for(int i = 1; i < size / 2; i++) temp = temp.next;

		ListNode prev = null;
		ListNode curr = temp.next;
		while(curr != null) {
			ListNode tempNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tempNext;
		}

		temp.next = prev;


		curr = head;
		temp = temp.next;
		//System.out.println("------");
		ListNode half = temp;
		//System.out.println(temp.val);

		while(half != null && size != 3){
			ListNode tempNext = curr.next;
			curr.next = temp;
			temp = temp.next;
			//System.out.println("temp: " + temp);

			if(tempNext.next == half){
				//System.out.println(tempNext.val + " " + curr.val + " " + temp.val + " " + curr.next.val);
				tempNext.next = temp;
				curr.next.next = tempNext;
				//temp.next = tempNext;
				break;
			}

			curr.next.next = tempNext;
			curr = tempNext;
		}

	}

	public int length(ListNode head) {
		if(head == null) return 0;
		return 1 + length(head.next);
	}


	public void reorderList2(ListNode head) {
		if(head == null || head.next == null){
			return;
		}

		ListNode dummyHead = new ListNode();
		dummyHead.next = head;

		ListNode slow = dummyHead;
		ListNode fast = dummyHead;

		while(fast != null && fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode middle = slow; // 2, 3

		ListNode tmp = middle.next;
		ListNode middleHead = new ListNode();

		// System.out.println(middle.val);

		while(tmp != null){
			ListNode tmp2 = tmp.next;
			tmp.next = middleHead.next;;
			middleHead.next = tmp;
			tmp = tmp2;
		}

		//         System.out.println(middleHead.next.val);

		//         ListNode looper = head;
		//         while(looper != null){
		//             System.out.println(":" + looper.val);
		//             looper = looper.next;
		//         }
		//         looper = middleHead;
		//         while(looper != null){
		//             System.out.println("-" + looper.val);
		//             looper = looper.next;
		//         }

		middleHead = middleHead.next;
		ListNode ptr = head;
		while(middleHead != null && ptr != middle.next){
			ListNode tmp3 = ptr.next;
			ptr.next = middleHead;

			// ListNode tmp4 = middleHead;
			ptr = middleHead;
			middleHead = tmp3;
			// System.out.println("+" + (ptr == null ? 0 : ptr.val) + " " + (middleHead == null ? 0 : middleHead.val));
		}
	}
}
