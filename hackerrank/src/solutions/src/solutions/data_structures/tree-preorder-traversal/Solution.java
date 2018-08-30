package solutions.data_structures.array_left_rotation;

import java.util.*;
import java.io.*;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Solution {

	/* you only have to complete the function given below.  
	Node is defined as  

	class Node {
	    int data;
	    Node left;
	    Node right;
	}

	 */

	public static void preOrder(Node root) {
		Node pre;
		if(root == null) {
			return;
		}
		

		Node curr = root;
		while(curr != null) {
			
			if(curr.left == null) {
				System.out.print(curr.data+" ");
				curr = curr.right;
			} else {
				pre = curr.left;
				
				while(pre.right !=null && pre.right != curr) {
					pre = pre.right;
				}
				
				if(pre.right == null) {
					pre.right = curr;
					System.out.print(curr.data+" ");
					curr = curr.left;
				} else {
					pre.right=null;
					curr=curr.right;
				}
			}
		}
	}

	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		preOrder(root);
	}	
}