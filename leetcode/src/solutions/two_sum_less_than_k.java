package solutions;

import java.util.Arrays;

public class two_sum_less_than_k {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        
        int start = 0;
        int end = A.length - 1;
        int max = -1;
        while(start < end) {
        	if(A[start] + A[end] < K) {
        		max = Math.max(max, A[start] + A[end]);
        		start++;
        	} else {
        		end--;
        	}
        }
        
        return max;
    }
}
