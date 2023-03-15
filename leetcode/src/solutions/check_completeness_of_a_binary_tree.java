package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class check_completeness_of_a_binary_tree {
	public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.peek() != null) {
        	q.add(q.peek().left);
        	q.add(q.poll().right);
        }
        while(!q.isEmpty() && q.peek() == null) {
        	q.poll();
        }
        
        return q.isEmpty();
    }
}
