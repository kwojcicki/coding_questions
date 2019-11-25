package solutions;

public class kth_smallest_element_in_a_bst {
	
	private static int count = 0;
	private static int number = 0;
	
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return number;
    }
    
    public void kthSmallestHelper(TreeNode root, int k) {
    	
    	if(root == null) {
    		return;
    	}
    	
    	if(count > k) {
    		return;
    	}
    	
    	kthSmallestHelper(root.left, k);
    	count++;
    	
    	if(count == k) {
    		number = root.val;
    	}
    	kthSmallestHelper(root.right, k);
    }
    
    
}
