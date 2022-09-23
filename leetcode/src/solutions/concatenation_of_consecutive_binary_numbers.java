package solutions;

public class concatenation_of_consecutive_binary_numbers {
    public int concatenatedBinary(int n) {
    	long ret = 0;
    	int mod = (int) (1E9 + 7);
    	for(int i = 1; i <= n; i++) {
    		String s = Integer.toBinaryString(i);
    		for(char c: s.toCharArray()) {
    			ret = ((ret << 1) + (c == '1' ? 1 : 0)) % mod;
    		}
    	}
    	
    	return (int) (ret % mod);   
    }
}
