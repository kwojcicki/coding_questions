package solutions;

import java.util.ArrayList;
import java.util.List;

public class combination_sum_iii {
	
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> ret = new ArrayList<>();
    	
    	recurse(ret, new ArrayList<>(), k, n, 1);
    	
    	return ret;
    }
    
    public static void recurse(List<List<Integer>> ret, List<Integer> curr, int size, int target, int start) {
    	if(target == 0 && curr.size() == size) {
    		ret.add(new ArrayList<>(curr));
    		return;
    	}
    	
    	if(curr.size() > size || target < 0) return;
    	
    	for(int i = start; i < 10; i++) {
    		curr.add(i);
    		recurse(ret, curr, size, target - i, i + 1);
    		curr.remove(curr.size() - 1);
    	}
    }
	
    public static List<List<Integer>> combinationSum31(int k, int n) {
    	List<List<Integer>> ret = new ArrayList<>();
    	
    	recurse(ret, new ArrayList<>(), k, n, 1);
    	
    	return ret;
    }
    
    public static void recurse1(List<List<Integer>> ret, List<Integer> curr, int size, int target, int lvl) {
    	if(curr.size() == size) {
    		int sum = curr.stream().reduce(0, Integer::sum);
    		if(sum == target) ret.add(new ArrayList<>(curr));
    		return;
    	}
    	
    	if(lvl == 10) return;
    	
    	curr.add(lvl);
    	recurse(ret, curr, size, target, lvl + 1);
    	curr.remove(curr.size() - 1);
    	
    	recurse(ret, curr, size, target, lvl + 1);
    }
    
    public static void main(String[] args) {
    	System.out.println(combinationSum3(3, 7));
    	System.out.println(combinationSum3(3, 9));
    }
}
