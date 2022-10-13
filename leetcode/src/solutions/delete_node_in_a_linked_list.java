package solutions;

public class delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
    	while(true) {
        	node.val = node.next.val;
            if(node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}
