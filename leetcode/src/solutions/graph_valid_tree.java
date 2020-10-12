package solutions;

import java.util.Arrays;

public class graph_valid_tree {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for(int[] e: edges) {
        	int x = find(nums, e[0]);
        	int y = find(nums, e[1]);
        	
        	if(x == y) return false;
        	
        	nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    public int find(int[] nums, int x) {
    	if(nums[x] == -1) return x;
    	return find(nums, nums[x]);
    }
}
