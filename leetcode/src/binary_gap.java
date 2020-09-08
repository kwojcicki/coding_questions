
public class binary_gap {
    public int binaryGap(int N) {
        int max = 0;
        int curr = -32;
        
        while(N > 0) {
        	if(N % 2 == 0) {
        		curr++;
        	} else {
        		max = Math.max(curr, max);
        		curr = 1;
        	}
        	
        	N /= 2;
        }
        
        return max;
    }
}
