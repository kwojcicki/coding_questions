package top_interview_easy.other;

public class number_of_1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        
        for(int i = 0; i < 32; i++){
            ret += n & 1;
            n >>= 1;
        }
        
        return ret;
    }
	
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }
}
