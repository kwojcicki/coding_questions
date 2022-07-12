package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class matchsticks_to_square {
	
	Set<List<Integer>> set = new HashSet<>();
	public boolean makesquare(int[] matchsticks) {

		int sum = Arrays.stream(matchsticks).sum();

		if(sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        int start = 0, end = matchsticks.length -1 ;
        while (start < end) {
        	int tmp = matchsticks[start];
        	matchsticks[start] = matchsticks[end];
        	matchsticks[end] = tmp;
        	start++;
        	end--;
        }

		return helper(matchsticks, 0, new int[] {0, 0, 0, 0}, sum /4);
	}
	
	public boolean helper(int[] arr, int index, int[] lengths, int sum) {
		if(index == arr.length) {
			return lengths[0] == lengths[1] && lengths[1] == lengths[2]
					&& lengths[2] == lengths[3];
		}
		
		List<Integer> check = Arrays.stream(lengths).boxed().collect(Collectors.toCollection(ArrayList::new));
		Collections.sort(check);
		if(set.contains(check)) return false;
		
		for(int i = 0; i < lengths.length; i++) {
			if(lengths[i] + arr[index] > sum) continue;
			lengths[i] += arr[index];
			if(helper(arr, index + 1, lengths, sum)) return true;
			lengths[i] -= arr[index];
		}
		
		set.add(check);
		return false;
	}
}
