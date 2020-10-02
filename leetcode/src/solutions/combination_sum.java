package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class combination_sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        
        for(int i = 0; i < candidates.length; i++) {
        	recurse(ret, candidates, target, i, 0, new ArrayList<>());
        }
        
        return ret.stream().collect(Collectors.toList());
    }
	
	public void recurse(Set<List<Integer>> ret, int[] candidates, int target, int number, int sum, List<Integer> curr) {
		if(sum > target) {
			return;
		}
		
		if(sum == target) {
			List<Integer> temp = new ArrayList<>(curr);
			ret.add(temp);
			return;
		}
		
		curr.add(candidates[number]);
		recurse(ret, candidates, target, number, sum + candidates[number], curr);
		curr.remove(curr.size() - 1);
		
		if(number + 1 < candidates.length) {
			curr.add(candidates[number + 1]);
			recurse(ret, candidates, target, number + 1, sum + candidates[number + 1], curr);
			curr.remove(curr.size() - 1);
			
			recurse(ret, candidates, target, number + 1, sum, curr);
		}
	}
}
