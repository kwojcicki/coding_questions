package solutions;

public class number_of_laser_beams_in_a_bank {
    public int numberOfBeams(String[] bank) {
    	int prev = 0;
    	int ret = 0;
    	
    	for(String s: bank) {
    		int curr = 0;
    		for(char c: s.toCharArray()) {
    			if(c == '1') curr++;
    		}
    		
    		if(curr == 0) continue;
    		ret += (prev * curr);
    		prev = curr;
    	}
    	
    	return ret;
    }
}
