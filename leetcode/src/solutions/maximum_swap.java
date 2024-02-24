package solutions;

public class maximum_swap {
	
	public int swap(int num, int idx1, int val1, int idx2, int val2) {
		return num - (val1 * (int)Math.pow(10, idx1))
				- (val2 * (int)Math.pow(10, idx2))
				+ (val1 * (int)Math.pow(10, idx2))
				+ (val2 * (int)Math.pow(10, idx1));
	}
	
    public int maximumSwap(int num) {
        int ret = num, tmp = num;
        int maxIdx = 0, maxDigit = 0;
        int currIdx = 0;
        
        while(tmp > 0) {
        	int currDigit = tmp % 10;
        	int swapped = swap(num, maxIdx, maxDigit, currIdx, currDigit);
        	ret = Math.max(swapped, ret);
        	
        	tmp = tmp / 10;
        	if(currDigit > maxDigit) {
        		maxDigit = currDigit;
        		maxIdx = currIdx;
        	}
        	currIdx++;
        }
        
        return ret;
    }
}
