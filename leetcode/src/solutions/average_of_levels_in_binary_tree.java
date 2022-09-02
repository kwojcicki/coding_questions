package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class average_of_levels_in_binary_tree {
    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> ret = new ArrayList<>();
    	ArrayDeque<TreeNode> q = new ArrayDeque<>();
    	q.add(root);
    	
    	while(!q.isEmpty()) {
    		Double curr = 0d;
    		int size = q.size();
    		for(int i = 0; i < size; i++) {
    			TreeNode n = q.poll();
    			curr += n.val;
    			if(n.left != null) q.add(n.left);
    			if(n.right != null) q.add(n.right);
    		}
    		ret.add(curr / size);
    	}
    	return ret;
    }
	
    public List<Double> averageOfLevels1(TreeNode root) {
        
    	List<Double> ret = new ArrayList<Double>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		int size = q.size();
    		double oldSize = q.size();
    		double sum = 0;
    		while(size > 0) {
        		TreeNode node = q.poll();
    			size--;
    			sum += node.val;
    			if(node.left != null) q.add(node.left);
    			if(node.right != null) q.add(node.right);
    		}
    		ret.add(sum / oldSize);
    	}
    	
    	return ret;
    }
}
