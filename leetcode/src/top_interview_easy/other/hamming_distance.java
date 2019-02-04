package top_interview_easy.other;

public class hamming_distance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
