package solutions;

import java.util.Arrays;

public class number_of_connected_components_in_an_undirected_graph {
    public int countComponents(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for(int[] e: edges) {
        	int x = find(nums, e[0]);
        	int y = find(nums, e[1]);
        	
        	if(x != y){
                nums[x] = y;   
                n--;
            }
        }
        
        return n;
    }
    
    public int find(int[] nums, int x) {
    	if(nums[x] == -1) return x;
    	return find(nums, nums[x]);
    }
}
