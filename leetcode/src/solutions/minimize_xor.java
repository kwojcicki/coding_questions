package solutions;

public class minimize_xor {
    public int minimizeXor(int num1, int num2) {
        // System.out.println(Integer.toBinaryString(num1) + " " + Integer.toBinaryString(num2));
        int num1Bits = Integer.bitCount(num1);
        int num2Bits = Integer.bitCount(num2);
        
        if(num1Bits == num2Bits) return num1;
        else if(num1Bits > num2Bits) {
        	int temp = 1;
        	while(Integer.bitCount(temp & num1) != num1Bits) temp = (temp << 1) | 1;
        	int temp2 = 1;
        	while(Integer.bitCount(num1 & (temp ^ temp2)) != num2Bits) temp2 = (temp2 << 1) | 1;
            // System.out.println(Integer.toBinaryString(temp) + " " + Integer.toBinaryString(temp2));
        	return num1 & (temp ^ temp2);
        }
        
        int num1Negated = ~num1;
        int ret = 1;
        int requiredBits = num2Bits - num1Bits;
        
        while(Integer.bitCount(ret & num1Negated) != requiredBits) {
        	ret = (ret << 1) | 1;
        }

        // System.out.println(Integer.toBinaryString(num1Negated) + " " + Integer.toBinaryString(ret));
    	// System.out.println(Integer.toBinaryString(num1Bits | (ret & num1Negated)));
    	return num1 | (ret & num1Negated);
    }
}
