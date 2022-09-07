package solutions;

public class construct_string_from_binary_tree {

	public String tree2str(TreeNode root) {
		if(root == null) return "";
		if(root.left == null && root.right == null) return Integer.toString(root.val);
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}

	public void helper(TreeNode root, StringBuilder s) {
		if(root == null) return;
		s.append(Integer.toString(root.val));
		if(root.left == null && root.right == null) return;
		s.append("(");
		if(root.right == null) {
			helper(root.left, s);
		} else {
			helper(root.left, s);
			s.append(")(");
			helper(root.right, s);
		}

		s.append(")");
	}

	public String tree2str1(TreeNode root) {
		if(root == null) return "";
		if(root.left == null && root.right == null) return Integer.toString(root.val);
		return Integer.toString(root.val) + "(" +
		(root.right == null ? tree2str1(root.left) : 
			tree2str1(root.left) +")(" + tree2str1(root.right) ) + ")";
	}
}
