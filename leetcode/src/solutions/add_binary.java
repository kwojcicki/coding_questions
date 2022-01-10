package solutions;

import java.math.BigInteger;

public class add_binary {
	public String addBinary1(String a, String b) {
		return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
	}

	public String addBinary(String a, String b) {
		StringBuilder ret = new StringBuilder();

		boolean carry = false;
		int i = 0;

		while(i < a.length() || i < b.length()) {
			int a1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
			int b1 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;

			int res = (carry ? 1 : 0) + a1 + b1;
			if(res > 1) {
				carry = true;
				res %= 2;
			} else {
				carry = false;
			}
			ret.append(res);
			i++;
		}

		if(carry) {
			ret.append('1');
		}

		return ret.reverse().toString();
	}
}
