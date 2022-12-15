package solutions.warmup.simple_array_sum;

import java.util.Arrays;

public class Solution {
    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
    	return Arrays.stream(ar).sum();
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {3, 5, 3, 7, 2, 6, 4};
    	//int[] a = new int[] {2, 3, 5, 2, 4, 3};
    	matrices(a);
    }
    
    public static void matrices(int[] P) {
    	int[][] m = new int[P.length - 1][P.length - 1];
    	int[][] k1 = new int[P.length - 1][P.length - 1];
    	for(int i = 0; i < m.length; i++) {
    		m[i][i] = 0;
    	}
    	
    	for(int l = 2; l <= m.length; l++) {
    		for(int i = 0; i < m.length - l + 1; i++) {
    			System.out.println("----------");
    			int j = i + l - 1;
    			System.out.println("i " + (i + 1) + " j " + (j + 1));
    			m[i][j] = Integer.MAX_VALUE;
    			for(int k = i; k < j; k++) {
    				int q = m[i][k] + m[k + 1][j] + P[i] * P[k + 1] * P[j + 1];
    				System.out.println("k " + (k + 1) + " q " + q);
    				System.out.println(P[i] + " " + P[k + 1] + " " + P[j + 1]);
    				System.out.println(m[i][k] + " " + m[k + 1][j]);
    				m[i][j] = Math.min(m[i][j], q);
    				
    				if(m[i][j] == q) {
    					k1[i][j] = k + 1;
    				}
    			}
    		}
    	}
    	
    	for(int[] a: m) {
    		System.out.println(Arrays.toString(a));
    	}
    	
    	System.out.println();
    	
    	for(int[] a: k1) {
    		System.out.println(Arrays.toString(a));
    	}
    }
}
