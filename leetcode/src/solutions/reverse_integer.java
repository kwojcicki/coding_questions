package solutions;

public class reverse_integer {
	public int reverse(int x) {
		int ret = 0;

		while(x != 0) {
			if(ret > 0 && ret > (Integer.MAX_VALUE - x % 10) / 10 ) return 0;
			if(ret < 0 && ret < (Integer.MIN_VALUE - x % 10) / 10 ) return 0;
			ret = (ret * 10) + x % 10;
			x /= 10;

		}
		return ret;
	}
}
