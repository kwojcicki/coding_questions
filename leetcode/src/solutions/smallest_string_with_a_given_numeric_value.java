package solutions;

public class smallest_string_with_a_given_numeric_value {
    public String getSmallestString(int n, int k) {
        StringBuilder ret = new StringBuilder(n);
        
        for(int i = 0; i < n; i++) {
        	System.out.println(k);
        	ret.append( (char) (Math.min(26, k - n + i + 1) + 96));
        	k -= Math.min(26,  k - n + i + 1);
        }
        
        return ret.reverse().toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(new smallest_string_with_a_given_numeric_value().getSmallestString(3, 27));
    }
}
