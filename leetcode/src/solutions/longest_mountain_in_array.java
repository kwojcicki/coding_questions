package solutions;

public class longest_mountain_in_array {
	
	public int longestMountain(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
	    
	    int max = 0;
	    
	    int left = 0;
	    int right = 0;
	    
	    while(left < A.length - 1) {
	    	
	    	right = left;
            
            if(right + 1 < A.length && A[right] < A[right + 1]){
                while(right + 1 < A.length && A[right] < A[right + 1]) right++;

                //System.out.println(right);
                if(right + 1 < A.length && A[left] < A[left + 1] && A[right] > A[right + 1]) {

                    while(right < A.length - 1 && A[right] > A[right + 1]) right++;

                    //System.out.println(right + " " + left);
                    max = Math.max(max, right - left + 1);

                }
            }
	    	
	    	left = Math.max(right, left + 1);
	    }
	    
	    return max;
	}
	
    public int longestMountain1(int[] A) {
        
        if(A == null || A.length == 0){
            return 0;
        }
        
    	int[] left = new int[A.length];
    	int[] right = new int[A.length];
    	
    	left[0] = 1;
    	right[A.length - 1] = 1;
    	
    	for(int i = 1; i < A.length; i++) {
    		if(A[i] > A[i - 1]) {
    			left[i] = left[i - 1] + 1;
    		} else {
    			left[i] = 1;
    		}
    	}
    	
    	
    	for(int i = A.length - 2; i >= 0; i--) {
    		if(A[i] > A[i + 1]) {
    			right[i] = right[i + 1] + 1;
    		} else {
    			right[i] = 1;
    		}
    	}
    	
    	int max = 0;
    	
    	for(int i = 1; i < left.length - 1; i++) {
            if(A[i] > A[i - 1] && A[i] > A[i + 1]) max = Math.max(max, left[i] + right[i]);
    	}
    	
    	return (max == 0 ? 0 : max - 1);
    }
}
