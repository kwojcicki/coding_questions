package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class most_frequent_subtree_sum {

	Map<Integer, Integer> counts = new HashMap<>();
	public int[] findFrequentTreeSum(TreeNode root) {
		dfs(root);
		
		int maxCount = 0;
		for(Entry<Integer, Integer> x: counts.entrySet()) {
			maxCount = Math.max(maxCount, x.getValue());
		}
		
		List<Integer> ret = new ArrayList<>();
		
		for(Entry<Integer, Integer> x: counts.entrySet()) {
			if(x.getValue() == maxCount) ret.add(x.getKey());
		}
		
		return ret.stream().mapToInt(i->i).toArray();
	}

	public int dfs(TreeNode root) {
		if(root == null) return 0;
		int s = root.val + dfs(root.left) + dfs(root.right);
		counts.put(s, counts.getOrDefault(s, 0) + 1);
		return s;
	}
}
