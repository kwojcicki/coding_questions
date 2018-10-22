package solutions.greedy.marcs_cakewalk;

import java.util.Arrays;

public class Solution {
	
    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {
    	Arrays.sort(calorie);
    	long toReturn = 0;
    	int j = 0;
    	for(int i = calorie.length - 1; i >= 0;i--) {
    		toReturn += Math.pow(2, j) * calorie[i];
    		j++;
    	}
    	return toReturn;
    }
    
    
}
