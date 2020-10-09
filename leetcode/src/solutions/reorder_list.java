package solutions;

public class reorder_list {
	public void reorderList(ListNode head) {
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
}
