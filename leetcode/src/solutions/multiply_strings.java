package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class multiply_strings {
	public static String multiply(String num1, String num2) {
		List<Character> ret = new ArrayList<>();
		ret.add('0');

		for(int i = num1.length() - 1; i >= 0; i--) {
			for(int j = num2.length() - 1; j >= 0; j--) {

				int result = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

				int index = (num1.length() - 1 - i) + (num2.length() - j - 1);

				while(ret.size() <= index) ret.add('0');

				result += ret.get(index) - '0';

				if(result > 9) {

					if(ret.size() <= index + 1) ret.add('0');
					result += (ret.get(index + 1) - '0') * 10;
					ret.set(index, (char)(result % 10 + '0'));
					index++;
					result /= 10;
				}

				ret.set(index, (char) (result + '0'));
			}
		}  	

		while(ret.get(ret.size() - 1) == '0' && ret.size() > 1) {
			ret.remove(ret.size() - 1);
		}


		System.out.println(ret);
		Collections.reverse(ret);
		return ret.stream().map(String::valueOf).collect(Collectors.joining());
	}

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "6"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("9133", "0"));
	}
}
