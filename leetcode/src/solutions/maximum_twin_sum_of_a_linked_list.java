package solutions;

public class maximum_twin_sum_of_a_linked_list {
    public int pairSum(ListNode head) {
    	 int ret = 0;
         
         ListNode fst = head;
         ListNode slw = head;
         
         while(fst != null && fst.next != null && fst.next.next != null) {
         	fst = fst.next.next;
         	slw = slw.next;
         }
         
         slw = slw.next;
         ListNode newHead = new ListNode();
         // System.out.println(slw.val);
         while(slw != null) {
             ListNode t = slw.next;
             slw.next = newHead.next;
         	newHead.next = slw;
             slw = t;
         }
         
         newHead = newHead.next;
         while(newHead != null) {
             // System.out.println(newHead.val + " " + head.val);
         	ret = Math.max(ret, newHead.val + head.val);
         	head = head.next;
         	newHead = newHead.next;
         }
         
         return ret;
    }
}
