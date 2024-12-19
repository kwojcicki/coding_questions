package solutions;

import java.util.HashSet;
import java.util.Set;

public class max_chunks_to_make_sorted {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int left = arr.length - 1;
        int target = arr.length - 1;
        Set<Integer> seen = new HashSet<>();
        
        while(left >= 0) {
            // System.out.println(arr[left] + " " + chunks + " " + target);
        	if(arr[left] == target) {
                left--;
                target--;
        		while(seen.contains(target)) {seen.remove(target--);}
                // System.out.println(seen);
                // System.out.println(target);
        		if(seen.isEmpty()) {
        			chunks++;
        			continue;
        		}
        	} else {
        		seen.add(arr[left]);
            left--;
        	}
        }
        
        return chunks;
    }
}
