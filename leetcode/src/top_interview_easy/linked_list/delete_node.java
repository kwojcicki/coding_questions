package top_interview_easy.linked_list;

public class delete_node {
	
    public void deleteNode(ListNode node) {
    	node.val=node.next.val;
        node.next=node.next.next;
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}