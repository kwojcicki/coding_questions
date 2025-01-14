package solutions;

public class find_the_prefix_common_array_of_two_arrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int[] ret = new int[A.length];
        boolean[] seen = new boolean[A.length + 1];
        
        for(int i = 0; i < A.length; i++) {
        	int prev = i == 0 ? 0 : ret[i - 1];
        	if(seen[A[i]]) {
                prev++;
        	}
        	seen[A[i]] = true;
        	if(seen[B[i]]) {
                prev++;
        	}
        	seen[B[i]] = true;
        		ret[i] = prev;
        }
        
        return ret;
    }
}
