package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class dota2_senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++) {
        	if(senate.charAt(i) == 'R') r.add(i);
        	else d.add(i);
        }
        
        while(!r.isEmpty() && !d.isEmpty()) {
        	int rI = r.poll();
        	int dI = d.poll();
        	if(rI < dI) r.add(rI + senate.length());
        	else d.add(dI + senate.length());
        }
        
        return d.isEmpty() ? "Radiant" : "Dire";
    }
}
