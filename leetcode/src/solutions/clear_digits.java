package solutions;

public class clear_digits {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()) {
        	if(Character.isDigit(c)) {
        		sb.deleteCharAt(sb.length() - 1);
        	} else {
        		sb.append(c);
        	}
        }
        
        return sb.toString();
    }
}
