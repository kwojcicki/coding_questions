package solutions;

public class kth_smallest_element_in_a_bst {
	
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return helper(root);
    }
    
    private int helper(TreeNode root){
        if(root == null) return -1;
        
        int right = helper(root.left);
        if(right != -1) return right;
        
        if(this.k == 1) return root.val;
        k--;
        
        int left = helper(root.right);
        if(left != -1) return left;
        
        return -1;
    }
	
	private static int count = 0;
	private static int number = 0;
	
    public int kthSmallest1(TreeNode root, int k) {
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
