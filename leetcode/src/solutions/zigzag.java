package solutions;

public class zigzag {

	static int maxSeenSoFar = 0;
	
	public static int longestZigZag(TreeNode r1) {
		maxSeenSoFar = 0;
		leftRight max = helper(r1);
		return Math.max(Math.max(max.left, max.right), maxSeenSoFar);
	}

	public static leftRight helper(TreeNode root) {
		if(root == null) {
			System.out.println("0, 0");
			return new leftRight();
		}

		leftRight left = helper(root.left);
		leftRight right = helper(root.right);

		leftRight ret = new leftRight();
		ret.left = 1 + left.right;
		ret.right = 1 + right.left;
		System.out.println(ret.left + " " + ret.right + " " + root);
		maxSeenSoFar = Math.max(maxSeenSoFar, Math.max(Math.max(left.left, left.right), Math.max(right.left, right.right)));
		return ret;
	}


	public static void main(String[] args) {
//		Node1 root = new Node1();
//		Node1 r1 = new Node1();
//		TreeNode r2 = new TreeNode();
//
//		root.left = r1;
//		r1.left = r2;

//		System.out.println("r2: " + longestZigZagPath(r2));
//		System.out.println("r1->r2: " + longestZigZagPath(r1));
//		System.out.println("root->r1->r2: " + longestZigZagPath(root));

		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(7);
		TreeNode r8 = new TreeNode(8);

		r1.right = r2;
		r2.left = r3;
		r2.right = r4;
		r4.left = r5;
		r4.right = r6;
		r5.right = r7;
		r7.right = r8;
		
		System.out.println("example 1: " + longestZigZag(r1));

		TreeNode r11 = new TreeNode(1);
		TreeNode r21 = new TreeNode(2);
		TreeNode r31 = new TreeNode(3);
		TreeNode r41 = new TreeNode(4);
		TreeNode r51 = new TreeNode(6);
		TreeNode r61 = new TreeNode(7);
		TreeNode r71 = new TreeNode(8);
		
		r11.left = r21;
		r11.right = r31;
		r21.right = r41;
		r41.left = r51;
		r41.right = r61;
		r51.right = r71;
		
		System.out.println("example 2: " + longestZigZag(r11));

	}

}

class leftRight {
	int left = -1, right = -1;
}

// given
class Node1 {
	Node1 left = null, right = null;
	int l = -1;
	public Node1() {
		
	}
	public Node1(int l) {
		this.l = l;
	}
	
	@Override
	public String toString() {
		return "[" + this.l + "]";
	}
}