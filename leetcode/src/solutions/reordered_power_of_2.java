package solutions;

import java.util.Arrays;

public class reordered_power_of_2 {
	public boolean reorderedPowerOf2(int n) {
		char[] s = Integer.toString(n).toCharArray();
		Arrays.sort(s);

		for(int i = 0; i < 32; i++) {
			char[] other = Integer.toString(1 << i).toCharArray();
			Arrays.sort(other);
			if(Arrays.equals(other, s)) return true;
		}
		return false;
	}

	public boolean reorderedPowerOf21(int n) {
		return helper(Integer.toString(n).toCharArray(), 0);
	}

	public boolean helper(char[] c, int index) {
		if(index == c.length) {
			if(c[0] == '0') return false;
			int tmp = 0;
			for(char t: c) {
				tmp = tmp * 10 + t - '0';
			}
			return (Math.log10(tmp) / Math.log10(2)) % 1 == 0;
		}

		for(int i = index; i < c.length; i++) {
			char tmp = c[i];
			c[i] = c[index];
			c[index] = tmp;
			if(helper(c, index + 1)) return true;
			tmp = c[i];
			c[i] = c[index];
			c[index] = tmp;
		}

		return false;
	}
}
