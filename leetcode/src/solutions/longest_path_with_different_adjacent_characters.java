package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longest_path_with_different_adjacent_characters {
	int max = 0;
	public int longestPath(int[] parent, String s) {
		Map<Integer, List<Integer>> m = new HashMap<>();
		for(int i = 0; i < parent.length; i++) {
			m.computeIfAbsent(parent[i], (k) -> new ArrayList<Integer>()).add(i);
		}
		// System.out.println(m);
		helper(0, m, s.toCharArray());
		// System.out.println(ret + " " + max + " " + Math.max(max, ret));
		return max;
	}

	public int helper(int i, Map<Integer, List<Integer>> m, char[] l) {
		int ret = 0;

		List<Integer> n = m.getOrDefault(i, List.of());
        int big1 = 0;
        int big2 = 0;
		for(int j: n) {
            int t = helper(j, m, l);
            if(l[j] != l[i]) { 
                if(t > big1){
                    big2 = big1;
                    big1 = t;
                } else if(t > big2){
                    big2 = t;
                }
            }
		}

		max = Math.max(max, big1 + big2 + 1);
		return big1 + 1;
	}
}
