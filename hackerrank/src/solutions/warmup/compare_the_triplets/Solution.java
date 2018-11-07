package solutions.warmup.compare_the_triplets;

import java.util.Arrays;
import java.util.List;

public class Solution {
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	Integer[] results = new Integer[] {0,0};
    	for(int i = 0; i < a.size(); i++) {
    		if(a.get(i) > b.get(i)) {
    			results[0]+=1;
    		} else if(a.get(i) < b.get(i)) {
    			results[1]+=1;
    		}
    	}
    	return Arrays.asList(results);
    }
    
    public static void main(String[] args) {
    	System.out.println(compareTriplets(Arrays.asList(new Integer[] {5,6,7}), 
    			Arrays.asList(new Integer[] {3,6,10})));
    }
}
