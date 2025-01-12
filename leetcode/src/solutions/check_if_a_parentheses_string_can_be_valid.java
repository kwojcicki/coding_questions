package solutions;

public class check_if_a_parentheses_string_can_be_valid {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 == 1) return false;

        char[] chars = s.toCharArray();
        char[] locks = locked.toCharArray();
        int open = 0;
        for(int i = 0; i < chars.length; i++) {
        	if(locks[i] == '0' || chars[i] == '(') open++;
        	else open--;
        	
        	if(open < 0) return false;
        }
        int closed = 0;
        for(int i = chars.length - 1; i >= 0; i--) {
        	if(locks[i] == '0' || chars[i] == ')') closed++;
        	else closed--;
        	
        	if(closed < 0) return false;
        }
        
        return true;
    }
}
