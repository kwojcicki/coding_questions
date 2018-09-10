package solutions;

import java.util.ArrayList;
import java.util.List;

public class fizz_buzz {
    public List<String> fizzBuzz(int n) {
        List<String> toReturn = new ArrayList<String>();
    	for(int i = 1; i <= n; i ++) {
    		if(i % 3 == 0 && i % 5 == 0) {
    			toReturn.add("FizzBuzz");
    		} else if(i % 3 == 0) {
    			toReturn.add("Fizz");
    		} else if(i % 5 == 0) {
    			toReturn.add("Buzz");
    		} else {
    			toReturn.add(i + "");
    		}
    	}
    	
    	return toReturn;
    }
}
