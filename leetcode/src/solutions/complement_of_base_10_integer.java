package solutions;

public class complement_of_base_10_integer {
    public int bitwiseComplement(int N) {
    	return ((int)Math.pow(2, Integer.toBinaryString(N).length()) - 1) ^ N;
    }
}
