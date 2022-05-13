package solutions;

public class populating_next_right_pointers_in_each_node_ii {

    public Node connect(Node root) {
        connect(root, null);
        return root;
    }
    
    public void connect(Node root, Node parent) {
    	if(root == null) return;
        
    	while(parent != null) {
    		if(parent.left != root && parent.left != null && 
              (parent.right == null || parent.right != root)) {
    			root.next = parent.left;
    			break;
    		}
    		
    		if(parent.right != root && parent.right != null) {
    			root.next = parent.right;
    			break;
    		}
    		
    		parent = parent.next;
    	}
        
    	connect(root.right, root);
    	connect(root.left, root);
    }
}
