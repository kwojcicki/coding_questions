package solutions;

public class serialize_and_deserialize_binary_tree {
	 
	 public class Codec {

	     // Encodes a tree to a single string.
	     public String serialize(TreeNode root) {
	         StringBuilder ret = new StringBuilder();
	         serialize(ret, root);
	         if(ret.length() > 0) ret.setLength(ret.length() - 1);
	         return ret.toString();
	     }
	     
	     public void serialize(StringBuilder ret, TreeNode root) {
	    	 if(root == null) {
	    		 ret.append("-1001,");
	    		 return;
	    	 }

	    	 ret.append(root.val + ",");
	    	 serialize(ret, root.left);
	    	 serialize(ret, root.right);
	     }

	     private int position = 0;
	     // Decodes your encoded data to tree.
	     public TreeNode deserialize(String data) {
	    	 position = -1;
	         return deserialize(data.split(","));
	     }
	     
	     private TreeNode deserialize(String[] data) {
	    	 position++;
	    	 if(position >= data.length) return null;
	    	 
	    	 int val = Integer.parseInt(data[position]);
	    	 
	    	 if(val == -1001) return null;
	    	 
	    	 TreeNode n = new TreeNode(val);
	    	 n.left = deserialize(data);
	    	 n.right = deserialize(data);
	    	 
	    	 return n;
	     }
	 }
	 
	 public static void main(String[] args) {
		 serialize_and_deserialize_binary_tree a = new serialize_and_deserialize_binary_tree();
		 Codec c = a.new Codec();
		 
		 
		 TreeNode one = new TreeNode(1);
		 TreeNode two = new TreeNode(2);
		 TreeNode three = new TreeNode(3);
		 TreeNode four = new TreeNode(4);
		 TreeNode five = new TreeNode(5);
		 
		 one.left = two;
		 one.right = three;
		 three.left = four;
		 three.right = five;
		 
		 System.out.println(c.serialize(one));
		 traverse(c.deserialize(c.serialize(one)));
	 }
	 
	 public static void traverse(TreeNode root) {
		 if(root == null) return;
		 
		 System.out.println(root.val);
		 traverse(root.left);
		 traverse(root.right);
	 }
}
