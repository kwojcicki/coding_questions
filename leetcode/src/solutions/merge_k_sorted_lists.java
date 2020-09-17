package solutions;

import java.util.PriorityQueue;

public class merge_k_sorted_lists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> {
        	return Integer.compare(a[0], b[0]);
        });
        
        ListNode ptr = null;
        
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) p.add(new int[] {lists[i].val, i });
        }
        
        while(!p.isEmpty()) {
        	int[] h = p.poll();
        	
        	if(head == null) {
        		ListNode temp = lists[h[1]];
        		if(temp.next != null) p.add(new int[] {temp.next.val, h[1]});
        		head = temp;
        		ptr = head;
        		lists[h[1]] = temp.next;
        	} else {
        		ListNode temp = lists[h[1]];
        		if(temp.next != null) p.add(new int[] {temp.next.val, h[1]});
        		ptr.next = temp;
        		lists[h[1]] = temp.next;
        		ptr = ptr.next;
        	}
        	
        }
        
        return head;
    }
}
