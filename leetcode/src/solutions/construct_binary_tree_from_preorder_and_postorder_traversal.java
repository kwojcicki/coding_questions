package solutions;

public class construct_binary_tree_from_preorder_and_postorder_traversal {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if(pre.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		root.left = constructFromPrePost(pre, post, 1, (pre.length - 1)/ 2);
		root.right = constructFromPrePost(pre, post, 1 + (pre.length - 1)/ 2, pre.length - 1);
		return root;
	}

	public TreeNode constructFromPrePost(int[] pre, int[] post, int start, int end) {
		System.out.println(start + " " + end);
		if(start > end) {
			return null;
		}
		TreeNode root = new TreeNode(pre[start]);
		if(start == end) {
			return root;
		}
		root.left = constructFromPrePost(pre, post, start + 1, start + (end - start)/2);
		root.right = constructFromPrePost(pre, post, start + (end - start)/2 + 1, end);
		return root;
	}
	
	public static void preorder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(TreeNode root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + " ");
	}

	public static void main(String[] args) {
		TreeNode root = new construct_binary_tree_from_preorder_and_postorder_traversal().constructFromPrePost(new int[] {1,2,4,5,3,6,7}, 
				new int[] {4,5,2,6,7,3,1});
		
		preorder(root);
		System.out.println();
		postorder(root);
	}
}
