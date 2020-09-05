package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class all_elements_in_two_binary_search_trees {
	
	public List<Integer> getAllElements1(TreeNode root1, TreeNode root2){
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		List<Integer> ret = new ArrayList<>();
		
		while(!s1.isEmpty() || !s2.isEmpty() || root1 != null || root2 != null) {
			
			while(root1 != null) {
				s1.push(root1);
				root1 = root1.left;
			}
			
			while(root2 != null) {
				s2.add(root2);
				root2 = root2.left;
			}
			
			if(s2.isEmpty() || (!s1.isEmpty() && s1.peek().val > s2.peek().val)) {
				root1 = s1.pop();
				ret.add(root1.val);
				root1 = root1.right;
			} else {
				root2 = s2.pop();
				ret.add(root2.val);
				root2 = root2.right;
			}
			
		}
		
		return ret;
	}
	
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    	List<Integer> l1 = new ArrayList<>();
    	List<Integer> l2 = new ArrayList<>();
    	List<Integer> res = new ArrayList<>();
    	traverse(l1, root1);
    	traverse(l2, root2);
    	
    	int idx1 = 0, idx2 = 0;
    	
    	while(idx1 < l1.size() && idx2 < l2.size()) {
    		if(l1.get(idx1) < l2.get(idx2)) {
    			res.add(l1.get(idx1));
    			idx1++;
    		} else {
    			res.add(l2.get(idx2));
    			idx2++;
    		}
    	}
    	
    	while(idx2 < l2.size()) {
    		res.add(l2.get(idx2));
    		idx2++;
    	}
    	
    	while(idx1 < l1.size()) {
    		res.add(l1.get(idx1));
    		idx1++;
    	}
    	
    	return res;
    }
    
    public void traverse(List<Integer> l, TreeNode root) {
    	if(root == null) return;
    	
    	traverse(l, root.left);
    	l.add(root.val);
    	traverse(l, root.right);
    }
}
