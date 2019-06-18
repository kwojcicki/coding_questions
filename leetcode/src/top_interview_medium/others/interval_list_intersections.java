package top_interview_medium.others;

import java.util.ArrayList;

public class interval_list_intersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> toReturn = new ArrayList<>();
        
        int a = 0;
        int b = 0;
        while(a < A.length && b < B.length) {
        	
        	if(intersect(A[a], B[b])) {
        		toReturn.add(new int[] { Math.max(A[a][0], B[b][0]), Math.min(A[a][1], B[b][1])});
        	}
        	
        	if(A[a][1] < B[b][1]) {
        		a++;
        	} else if(A[a][1] > B[b][1]) {
        		b++;
        	} else {
        		a++;
        		b++;
        	}
        }
        
        int[][] x = new int[toReturn.size()][2];
        for(int i = 0; i < toReturn.size(); i++) {
        	x[i] = toReturn.get(i);
        }
        
        return x;
    }
    
    public static boolean intersect(int[] A, int[] B) {
    	
    	int[] x = new int[] { Math.max(A[0], B[0]), Math.min(A[1], B[1])};
    	
    	if(A[0] <= x[0] && B[0] <= x[0] && B[1] >= x[1] && A[1] >= x[1] && x[0] <= x[1]) {
    		return true;
    	}
    	
    	return false;
    	
    }
}
