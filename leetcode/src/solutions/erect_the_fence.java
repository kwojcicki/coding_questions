package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class erect_the_fence {
	public int[][] outerTrees(int[][] trees) {
        Set<int[]> s = new HashSet<>();
        
        Arrays.sort(trees, (a,b) -> {
        	if(a[0] == b[0]) {
        		return Integer.compare(a[1], b[1]);
        	}
        	
        	return Integer.compare(a[0], b[0]);
        });
        
        Stack<int[]> lower = new Stack<>();
        Stack<int[]> upper = new Stack<>();
        
        for(int[] t: trees) {
        	while(lower.size() >= 2) {
        		int[] tmp = lower.pop();
        		if(cmp(lower.peek(), tmp, t) > 0) {
        			continue;
        		}
        		lower.add(tmp);
        		break;
        	}
        	
        	while(upper.size() >= 2) {
        		int[] tmp = upper.pop();
        		if(cmp(upper.peek(), tmp, t) < 0) {
        			continue;
        		}
        		upper.add(tmp);
        		break;
        	}
        	
        	lower.add(t);
        	upper.add(t);
        }
        
        while(!lower.isEmpty()) {
        	s.add(lower.pop());
        }
        
        while(!upper.isEmpty()) {
        	s.add(upper.pop());
        }

        int[][] ret = new int[s.size()][2];
        int i = 0;
        for(int[] a: s) {
        	ret[i++] = a;
        }
        
        return ret;
    }
    
    public int cmp(int[] p1, int[] p2, int[] p3) {
    	// return (y3-y2)*(x2-x1) - (y2-y1)*(x3-x2)
    	return (p3[1] - p2[1]) * (p2[0] - p1[0]) - (p2[1] - p1[1]) * (p3[0] - p2[0]);
    }
}
