package solutions;

public class rotate_list {

	public int helper(ListNode head) {
		if(head == null) {
			return 0;
		}
		
		return 1 + helper(head.next);
	}
	
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null){
            return head;
        }
        
        int length = helper(head);
        int size = length - k % length;
        
        if(size == length){
            return head;
        }
        
        ListNode tmpHead = head;
        ListNode end = head;
        
        while(end.next != null) {
        	end = end.next;
        }
        
        for(int i = 0; i < size - 1; i++) {
        	head = head.next;
        }
        
        ListNode tmp = head.next;
        head.next = null;
        head = tmp;
        end.next = tmpHead;
        
        return head;
    }
	
	public ListNode rotateRight1(ListNode head, int k) {
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
