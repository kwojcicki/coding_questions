package solutions;

public class string_to_integer_atoi {
	public int myAtoi(String s) {
		boolean start = true;
		boolean positive = true;

		int ret = 0;
		for(char c: s.toCharArray()) {
			if(start && c == ' ') {
				continue;
			}

			if(start && c == '+'){
				start = false;
				continue;
			}

			if(!start && !Character.isDigit(c)){
				break;
			} else if(c == '-' || c == '+') {
				start = false;
				if(c == '-') {
					positive = false;
				}
				continue;
			} else if(!Character.isDigit(c)){
				break;
			}

			start = false;

			int number = c - '0';

			if( (number + (long) ret * 10) != number + ret * 10) {
				if(positive) return Integer.MAX_VALUE;
				return Integer.MIN_VALUE;
			}

			ret = ret * 10 + number;
			// System.out.println(ret);
			// System.out.println(Integer.MAX_VALUE);
		}

		return positive ? ret : - ret;
	}

	public static void main(String[] args) {
		System.out.println(new string_to_integer_atoi().myAtoi("-6147483648"));
	}
}
