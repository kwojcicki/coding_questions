package solutions;

public class cousins_in_binary_tree {
	
	static TreeNode px = null;
	static TreeNode py = null;
	
    public boolean isCousins(TreeNode root, int x, int y) {
    	int dx = find(root, x, 0, true);
    	int dy = find(root, y, 0, false);
    	
    	System.out.println(dy + " " + dx);
    	System.out.println(py + " " + px);
    	System.out.println(px.val + " " + py.val);
    	if(dy == dx && px != py) {
    		return true;
    	}
    	return false;
    }
    
    public static int find(TreeNode node, int val, int depth, boolean left) {
    	if(node == null) {
    		return -1;
    	}
    	System.out.println("val : " + node.val + " " + node.left + " " + node.right);
    	if(node.val == val) {
    		return depth;
    	}
    	
    	if(node.left != null) {
    		System.out.println("here: " + node.left.val + " " + val);
    		if(node.left.val == val) {
    			if(left) {
    				px = node;
    			} else {
    				py = node;
    			}
        		System.out.println("found");
        		return depth + 1;
    		}
    	}
    	
    	if(node.right != null) {
    		System.out.println("haere");
    		if(node.right.val == val) {
    			if(left) {
    				px = node;
    			} else {
    				py = node;
    			}
        		return depth + 1;
    		}
    	}
    	
    	int x1 = find(node.left, val, depth + 1, left);
    	int x2 = find(node.right, val, depth + 1, left);
    	
    	if(x1 != -1) return x1;
    	if(x2 != -1) return x2;
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	TreeNode p1 = new TreeNode(1);
    	TreeNode p2 = new TreeNode(2);
    	TreeNode p3 = new TreeNode(3);
    	TreeNode p4 = new TreeNode(4);
    	TreeNode p5 = new TreeNode(5);
    	
    	p1.left = p2;
    	p1.right = p3;
    	
    	p2.right = p4;
    	
    	p3.right = p5;
    	
    	System.out.println(new cousins_in_binary_tree().isCousins(p1, 5, 4));
    }
    
}
