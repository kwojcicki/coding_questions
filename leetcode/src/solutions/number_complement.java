package solutions;

public class number_complement {
    public int findComplement(int num) {
    	int mask = 1;
    	while(mask < num) {
    		mask = (mask << 1) | 1;
    		System.out.println(mask);
    	}
    	return ~num & mask;
    }
    
    public static void main(String[] args) {
    	new number_complement().findComplement(5);
    }
}
