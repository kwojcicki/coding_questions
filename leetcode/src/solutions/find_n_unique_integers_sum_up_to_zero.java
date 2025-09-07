package solutions;

public class find_n_unique_integers_sum_up_to_zero {
    public int[] sumZero(int n) {
        int[] ret = new int[n];
        
        for(int i = 0; i < n / 2; i++) {
        	ret[i] = -(n - i);
        	ret[ret.length - i - 1] = (n - i);
        }
        
        return ret;
    }
}
