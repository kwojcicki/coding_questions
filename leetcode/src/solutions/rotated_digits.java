package solutions;

import java.util.stream.IntStream;

public class rotated_digits {
    public int rotatedDigits(int N) {
    	// dp
        return (int)IntStream.range(1, N + 1).filter(i -> {
        	String is = Integer.toString(i);
        	if((is.contains("2") || 
        			is.contains("5") ||
        			is.contains("6") ||
        			is.contains("9")) && 
        			!is.contains("3")&& 
        			!is.contains("4")&& 
        			!is.contains("7")) {
        		return true;
        	}
        	return false;
        }).count();
    }
}
