package solutions;

import java.util.Arrays;

public class bag_of_tokens {

    public int bagOfTokensScore1(int[] tokens, int power) {
    	Arrays.sort(tokens);
        int ret = 0, curr = 0;
        int start = 0, end = tokens.length - 1;
        while(start <= end) {
        	if(power >= tokens[start]) {
        		power -= tokens[start];
        		start++;
        		curr++;
            } else if(curr == 0){ 
                break;
        	} else {
        		power += tokens[end];
        		end--;
        		curr--;
        	}
        	ret = Math.max(ret, curr);
        }
        
        return ret;
    }
	
	public int bagOfTokensScore(int[] tokens, int P) {
		int ret = 0;
		Arrays.sort(tokens);

		int start = 0; 
		int end = tokens.length - 1;

		while(start <= end) {

			if(tokens[start] <= P) {
				ret++;
				P -= tokens[start];
				start++;
			} else if(ret == 0){
				break;
			} else if(start + 1 < end) {
				ret--;
				P += tokens[end];
				end--;
			} else {
				break;
			}

		}

		return ret;
	}
}
