package solutions;

public class complement_of_base_10_integer {
    public int bitwiseComplement1(int N) {
    	return ((int)Math.pow(2, Integer.toBinaryString(N).length()) - 1) ^ N;
    }
    
    public int bitwiseComplement(int N) {
        int mask = 1;
    	while(mask < N) {
    		mask = (mask << 1) + 1;
    	}
    	// 1111111
    	// 1010101
    	
    	return ~N & mask;
    }
}
