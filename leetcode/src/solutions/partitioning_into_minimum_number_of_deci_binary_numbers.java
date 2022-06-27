package solutions;

public class partitioning_into_minimum_number_of_deci_binary_numbers {
    public int minPartitions(String n) {
    	int ret = 0;
    	
    	for(char c: n.toCharArray()) {
    		ret = Math.max(c, ret);
    	}
    	
    	return ret - '0';
        // return (int) n.chars().reduce((a,b) -> Math.max(a, b)).getAsInt() - '0';
    }
}
