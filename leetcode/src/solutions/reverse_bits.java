package solutions;

public class reverse_bits {

	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int ret = 0;

		int i = 32;
		while(i > 0) {
			ret = ret << 1;
			ret |= (n & 1);
			// System.out.println(n & 1);
			n = n >> 1;
			i--;
		}

		return ret;
	}
}
