package solutions;

import java.util.HashMap;
import java.util.Map;

public class construct_binary_tree_from_preorder_and_inorder_traversal {
	int i = 0;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
        	m.put(inorder[i], i);
        }
        
        return helper(preorder, m, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, Map<Integer, Integer> map, int start, int end) {
        // if(i >= preorder.length) return null;
        if(end < start) return null;
        if(start == end) return new TreeNode(preorder[i++]);
    	TreeNode n = new TreeNode(preorder[i++]);

    	int index = map.get(preorder[i - 1]);
    	// System.out.println(start + " " + end);
    	// System.out.println(start + " " + (index - 1) + " - " + (index + 1) + " " + end);
    	n.left = helper(preorder, map, start, index - 1);
    	n.right = helper(preorder, map, index + 1, end);
    	
    	return n;
    }
}
