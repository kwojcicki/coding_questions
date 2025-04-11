package solutions;

public class count_symmetric_integers {
    public int countSymmetricIntegers(int low, int high) {
        int ret = 0;
        for(int i = low; i <= high; i++) {
        	if(i < 100 && i > 10) {
        		// 2 digits
        		int rightDigit = i % 10;
        		int leftDigit = i / 10;
        		if(rightDigit == leftDigit) ret++;
        	} else if(i < 10000 && i >= 1000) {
        		// 4 digits
        		int r1 = i % 10;
        		int r2 = (i / 10) % 10;
        		int l2 = (i / 100) % 10;
        		int l1 = (i / 1000) % 10;
        		if(r1 + r2 == l2 + l1) ret++;
        	}
        }
        
        return ret;
    }
}
