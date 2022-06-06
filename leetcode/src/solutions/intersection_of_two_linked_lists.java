package solutions;

public class intersection_of_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNode(headA, headB, headA, headB);
    }
    
    public ListNode getIntersectionNode(ListNode a, ListNode b, ListNode headA, ListNode headB) {
        return a == b ? a : getIntersectionNode(a == null ? headB : a.next, b == null ? headA : b.next, headA, headB);
    }
}
