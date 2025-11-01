package solutions;

public class delete_nodes_from_linked_list_present_in_array {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        Set<Integer> numSet = new HashSet<>();
        for(int i: nums) numSet.add(i);

        while(head != null){
            // System.out.println(head.val);
            if(!numSet.contains(head.val)) { curr.next = head; curr = curr.next; }
            head = head.next;
        }

        curr.next = null;

        return newHead.next;
    }
}
