package solutions;

import java.util.Arrays;
import java.util.List;

public class richest_customer_wealth {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
        		.map(i -> Arrays.stream(i).sum())
        		.max(Integer::compare).orElse(0);
    }
    
    public int maximumWealth(List<List<Integer>> accounts) {
        return accounts.stream()
        		.map(i -> i.stream().reduce((a,b) -> a + b).orElse(0))
        		.max(Integer::compare).orElse(0);
    }
    
    public int maximumWealth1(int[][] accounts) {
    	int ret = 0;
    	
    	for(int i = 0; i < accounts.length; i++) {
    		int curr = 0;
    		for(int j = 0; j < accounts[0].length; j++) {
    			curr += accounts[i][j];
    		}
    		
    		ret = Math.max(ret, curr);
    	}
    	
    	return ret;
    }
}
