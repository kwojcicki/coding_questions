package solutions;

import java.util.Arrays;

public class bag_of_tokens {
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
