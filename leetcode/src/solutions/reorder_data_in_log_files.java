package solutions;

import java.util.Arrays;

public class reorder_data_in_log_files {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (a, b) -> {
    		String log1 = a.substring(a.indexOf(' ') + 1);
    		String log2 = b.substring(b.indexOf(' ') + 1);
    		
    		boolean log1Digit = true;
    		boolean log2Digit = true;
    		
    		for(char c: log1.toCharArray()) {
    			if(!Character.isWhitespace(c) && !Character.isDigit(c)) log1Digit = false;
    		}
    		
    		for(char c: log2.toCharArray()) {
    			if(!Character.isWhitespace(c) && !Character.isDigit(c)) log2Digit = false;
    		}
    		
    		if(log1Digit && log2Digit) return 0;
    		
            if(log1Digit) return 1;
            if(log2Digit) return -1;
            
    		if(log1.compareTo(log2) == 0) {
    			return a.substring(0, a.indexOf(' ')).compareTo(b.substring(0, b.indexOf(' ')));
    		}
    		
    		return log1.compareTo(log2);
    	});
    	
    	return logs;
    }
}
