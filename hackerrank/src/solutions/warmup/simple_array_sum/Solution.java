package solutions.warmup.simple_array_sum;

import java.util.Arrays;

public class Solution {
    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
    	return Arrays.stream(ar).sum();
    }
}
