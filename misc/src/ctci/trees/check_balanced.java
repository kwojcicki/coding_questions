package ctci.trees;

public class check_balanced {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(-1);
		t1.left = t2;
		System.out.println(isBalanced(t1));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return checkBalancedHelper(root) != -1;
	}
	
	public static int checkBalancedHelper(TreeNode root) {
		if(root == null) return 0;
		
		int leftTree = checkBalancedHelper(root.left);
		int rightTree = checkBalancedHelper(root.right);
		
		// -1 might not be good choice as -1 can also mean null tree
		if(leftTree == -1 || rightTree == -1) {
			return -1;
		}
		
		return (Math.abs(leftTree - rightTree) > 1) ? -1 : Math.max(leftTree, rightTree) + 1;
	}
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}