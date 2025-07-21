package solutions;

public class delete_characters_to_make_fancy_string {
    public String makeFancyString(String s) {
    	if(s.length() <= 2) return s;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(chars[0] + "" + chars[1]);

        for(int i = 2; i < chars.length; i++) {
        	char c = chars[i];
        	if(c == sb.charAt(sb.length() - 1) && c == sb.charAt(sb.length() - 2)) {
        		continue;
        	}
        	sb.append(c);
        }
        
        return sb.toString();
    }
}
