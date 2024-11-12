package solutions;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class most_beautiful_item_for_each_query {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ret = new int[queries.length];
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(0, 0);
        
        for(int[] i: items) {
        	Entry<Integer, Integer> e = m.floorEntry(i[0]);
        	if(e.getValue() < i[1]) m.put(i[0], i[1]);
        }
        
        for(int q = 0; q < queries.length; q++) {
        	ret[q] = m.floorEntry(q).getValue();
        }
        
        return ret;
    }
}
