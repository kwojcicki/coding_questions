package solutions;

public class smallest_integer_divisible_by_k {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        
        int r = 0;
        for (int n = 1; n <= K; n++) {
            r = (r * 10 + 1) % K;
            if (r == 0) return n;
        }
        return -1;
    }
}
