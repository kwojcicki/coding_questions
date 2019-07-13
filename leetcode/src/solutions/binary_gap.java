package solutions;

public class binary_gap {
    public int binaryGap(int N) {
        String s = Integer.toBinaryString(N);
        int ret = 0;
        
        int last = s.indexOf('1');
        System.out.println(s);
        for(int i = s.indexOf('1') + 1; i < s.length(); i++) {
        	if(s.charAt(i) == '1') {
        		ret = Math.max(ret, i - last);
        		last = i;
        	}
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	System.out.println(new binary_gap().binaryGap(22));
    }
    
}
