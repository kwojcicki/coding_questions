package solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class serialize_and_deserialize_bst {
	
	public class Codec {
		
	    public String serialize(TreeNode root) {
	    	if(root == null) return null;
	        StringBuilder curr = new StringBuilder();
	        
	        postorder(root, curr);
	        
	        curr.setLength(curr.length() - 1);
	        
	        return curr.toString();
	    }
	    
	    public void postorder(TreeNode root, StringBuilder curr) {
	    	if(root == null) return;
	    	
	    	postorder(root.left, curr);
	    	postorder(root.right, curr);
	    	
	    	curr.append(root.val + ",");
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	if(data == null) return null;
	    	String[] nodes = data.split(",");
	    	Deque<Integer> q = new LinkedList<>();
	    	for(String s: nodes) {
	    		q.add(Integer.parseInt(s));
	    	}
	    	return create(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
	    }
	    
	    public TreeNode create(Integer min, Integer max, Deque<Integer> n) {
	    	if(n.isEmpty()) return null;
	    	
	    	Integer val = n.peekLast();
	    	if(val < min || val > max) {
	    		return null;
	    	}
	    	
	    	n.pollLast();
	    	
	    	TreeNode root = new TreeNode(val);
	    	root.right = create(val, max, n);
	    	root.left = create(min, val, n);
	    	
			return root;
	    }
	}
	
	public class Codec1 {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	if(root == null) return null;
	        StringBuilder curr = new StringBuilder();
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()) {
	        	boolean done = true;

	        	for(int i = q.size() - 1; i >= 0; i--) {
	        		TreeNode n = q.poll();
	        		if(n == null) {
	        			q.add(null);
	        			q.add(null);
	        			curr.append(",null");
	        		} else {
	        			q.add(n.left);
	        			q.add(n.right);
	        			curr.append("," + n.val);
	        			done = false;
	        		}
	        	}
	        	
	        	if(done) break;
	        }
	        
	        return curr.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if (data == null) return null;
	        String[] nodes = data.split(",");
	        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
	        create(root, nodes, 0);
	        return root;
	    }
	    
	    public void create(TreeNode root, String[] nodes, int index) {
	    	if(index >= nodes.length - 2) return;
	    	
	    	if(!nodes[index * 2 + 1].equals("null")) {
	    		root.left = new TreeNode(Integer.parseInt(nodes[index * 2 + 1]));
	    		create(root.left, nodes, index * 2 + 1);
	    	}
	    	
	    	if(!nodes[index * 2 + 2].equals("null")) {
	    		root.right = new TreeNode(Integer.parseInt(nodes[index * 2 + 2]));
	    		create(root.right, nodes, index * 2 + 2);
	    	}
	    }
	}
}
