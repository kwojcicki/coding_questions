package solutions;

public class maximum_69_number {
    public int maximum69Number (int num) {
        char[] c = Integer.toString(num).toCharArray();
        
        for(int i = 0; i < c.length; i++) {
        	if(c[i] == '6') {
        		c[i] = '9';
        		return Integer.parseInt(new String(c));
        	}
        }
        
        return num;
    }
}
