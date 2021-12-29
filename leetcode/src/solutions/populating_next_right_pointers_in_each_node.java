package solutions;

public class populating_next_right_pointers_in_each_node {
    public Node connect(Node root) {
    	
    	if(root == null) return root;
    	
    	if(root.left != null) root.left.next = root.right;
    	if(root.next != null && root.right != null) root.right.next = root.next.left;
    	

    	connect(root.right);
    	connect(root.left);
    	
    	return root;
    }
    
    public Node connect1(Node root) {
        if(root == null || root.left == null) return root;
        
        root.left.next = root.right;
        root.right.next = root.next != null ? root.next.left : null;
        
        connect(root.left);
        connect(root.right);
        return root;
    }
}
