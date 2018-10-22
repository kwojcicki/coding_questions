package solutions.greedy.max_min;

import java.util.Arrays;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	Arrays.sort(arr);
    	int unfairness = Integer.MAX_VALUE;
    	
    	for(int i = 0; i + k - 1 < arr.length; i++) {
    		unfairness = Math.min(unfairness, arr[i + k - 1] - arr[i]);
    	}
    	
    	return unfairness;
    }
    
    public static void main(String[] args) {
    	int[] arr = { 10, 100, 300, 200, 1000, 20, 30};
    	System.out.println(maxMin(3, arr));
    }
}