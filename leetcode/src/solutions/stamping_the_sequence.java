package solutions;

import java.util.ArrayList;
import java.util.List;

public class stamping_the_sequence {
	public int[] movesToStamp(String stamp, String target) {
        List<Integer> ret = new ArrayList<>(target.length());
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();
        
        boolean changed = true;
        while(changed) {
        	changed = false;
        	for(int i = 0; i < target.length() - s.length + 1; i++) {
                if(change(s, t, i)){
                    changed = true;
                    ret.add(0, i);
                }
        	}
            // System.out.println(Arrays.toString(t));
        }
        
        for(char c: t){
            if(c != '?') return new int[0];
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
    
    public boolean change (char[] s, char[] t, int index) {
    	boolean found = false;
    	for(int i = 0; i < s.length; i++) {
    		if(t[index + i] == '?') continue;
    		if(s[i] != t[index + i]) return false;
    		found = true;
    	}
    	
    	if(!found) return false;
    	for(int i = index; i < s.length + index; i++) {
    		t[i] = '?';
    	}
        // System.out.println(index);
    	return true;
    }
}
