import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class smallest_string_with_swaps {

	public int find(int[] union, int i) {
		return union[i] == i ? i : find(union, union[i]);
	}
	
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] union = new int[s.length()];
        StringBuilder ret = new StringBuilder(s);
        
        for(List<Integer> pair: pairs) {
        	int x = pair.get(0);
        	int y = pair.get(1);
        	
        	x = find(union, x);
        	y = find(union, y);
        	if(x != y) {
        		if (-union[x] < -union[y]) {
        			union[y] += union[x];
                    union[x] = y;
        		} else {
        			union[x] += union[y];
                    union[y] = x;
        		}
        	}
        }
        
        Map<Integer, List<Integer>> lists = new HashMap<>();
        
        for(int i = 0; i < union.length; i++) {
        	int x = find(union, i);
        	lists.putIfAbsent(x, new ArrayList<>());
        	lists.get(x).add(i);
        }
        
        for(List<Integer> list: lists.values()) {
        	Collections.sort(list);
        	char[] c = new char[list.size()];
        	for(int i = 0; i < list.size(); i++) {
        		c[i] = s.charAt(list.get(i));
        	}
        	Arrays.sort(c);
        	for(int i = 0; i < list.size(); i++) {
        		ret.setCharAt(list.get(i), c[i]);
        	}
        }
        
        return ret.toString();
    }
}
