package top_interview_medium.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pancake_sorting {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> x = new ArrayList<Integer>();
        
        for(int i = A.length - 1; i > 0; i--) {
        	System.out.println(i);
        	int maxPos = 0;
        	for(int j = 1; j <= i; j++) {
        		if(A[j] > A[maxPos]) {
        			maxPos = j;
        		}
        	}
        	
        	if(maxPos == i) {
        		continue;
        	}
        	
        	x.add(maxPos + 1);
        	x.add(i + 1);
        	
        	reverse(A, maxPos + 1);
        	reverse(A, i + 1);
        }
        
        
        System.out.println(x);
        System.out.println(Arrays.toString(A));
        return x;
    }
    
    public static void reverse(int[] A, int k) {
    	System.out.println("pre:  " + Arrays.toString(A) + " pos: " + k);
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    	System.out.println("post: " + Arrays.toString(A) + " pos: " + k);
    }
    
    public static void main(String[] args) {
    	new pancake_sorting().pancakeSort(new int[] {3, 2, 4, 1});
    }
}
