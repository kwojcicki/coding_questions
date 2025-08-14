package solutions;

public class largest_3_same_digit_number_in_string {
    public String largestGoodInteger(String num) {
        int max = -1;
        char[] chars = num.toCharArray();
        
        for(int i = 2; i < chars.length; i++) {
        	if(chars[i] != chars[i - 1]) {
        		i++; continue;
        	} else if(chars[i] != chars[i - 2]) continue;
        	
        	max = Math.max(max, chars[i] - '0');
        }
        
        if(max == -1) return "";
        
        char maxChar = (char) (max + '0');
        
        return maxChar + "" + maxChar + "" + maxChar;
    }
}
