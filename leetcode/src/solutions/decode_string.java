package solutions;

public class decode_string {

	public String helper1(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}

		if(!Character.isDigit(s.charAt(0))) {
			return s.charAt(0) + helper1(s.substring(1));
		}


		int loop = s.charAt(0) - '0';

		while(Character.isDigit(s.charAt(1))) {
			s = s.substring(1);
			loop *= 10;
			loop += s.charAt(0) - '0';
		}

		int end = s.indexOf(']');

		int opening = 1; int closing = 0;
		for(int i = 2; i < s.length(); i++) {
			if(s.charAt(i) == '[') opening++;
			if(s.charAt(i) == ']') closing++;

			if(closing == opening) {
				end = i;
				break;
			}
		}


		String toRepeat = helper1(s.substring(2, end));

		String ret = "";

		for(int i = 0; i < loop; i++) {
			ret += toRepeat;
		}

		return ret + helper1(s.substring(end + 1));
	}

	public String decodeString1(String s) {
		return helper1(s);
	}
	
    int index = 0;
	public String decodeString(String s) {
		if(s == null || s.length() == 0) return "";
		return helper(s.toCharArray(), new StringBuilder());
	}
	
	public String helper(char[] c, StringBuilder sb) {
		if(index == c.length) return sb.toString();
        
		if(Character.isAlphabetic(c[index])) {
			sb.append(c[index]);
            ++index;
			return helper(c, sb);
		}
		
		if(c[index] == ']') {
            ++index;
			return sb.toString();
		}
		
		// should check if its actually a number
		int number = c[index] - '0';
        
		index++;
		while(c[index] != '[') {
			number = number * 10 + c[index] - '0';
            index++;
		}
		
        index++;
		// technically could reuse passed in stringbuilder
		String result = helper(c, new StringBuilder());
		
		for(int i = 0; i < number; i++)
			sb.append(result);
		
		return sb.toString() + helper(c, new StringBuilder());
	}
}
