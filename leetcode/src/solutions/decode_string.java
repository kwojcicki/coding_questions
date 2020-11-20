package solutions;

public class decode_string {
	
	public String helper(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
		
		if(!Character.isDigit(s.charAt(0))) {
			return s.charAt(0) + helper(s.substring(1));
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
		
        
		String toRepeat = helper(s.substring(2, end));
		
		String ret = "";
		
		for(int i = 0; i < loop; i++) {
			ret += toRepeat;
		}
		
		return ret + helper(s.substring(end + 1));
	}
	
    public String decodeString(String s) {
        
       return helper(s);
    }
}
