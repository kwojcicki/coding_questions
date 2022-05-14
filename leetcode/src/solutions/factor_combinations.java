package solutions;

import java.util.ArrayList;
import java.util.List;

public class factor_combinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        fill(ret, new ArrayList<>(), n, 2);
        return ret;
    }
    
    public void fill(List<List<Integer>> ret, List<Integer> curr, int n, int index) {
    	if(n == 1) {
    		ret.add(new ArrayList<>(curr));
    		return;
    	}
    	
    	for(int i = index; i < n - 1; i++) {
    		if(n % i == 0) {
    			curr.add(i);
    			fill(ret, curr, n / i, i);
    			curr.remove(curr.size() - 1);
    		}
    	}
    }
}
