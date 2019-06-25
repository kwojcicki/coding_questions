package top_interview_medium.others;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class keys_and_rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
    	boolean[] roomsSeen = new boolean[rooms.size()];
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(0);
    	
    	while(!q.isEmpty()) {
    		
    		Integer x = q.poll();
    		if(roomsSeen[x]) {
    			continue;
    		}
    		
    		roomsSeen[x] = true;
			q.addAll(rooms.get(x));
    	}
    	
    	
    	for(boolean p: roomsSeen) {
    		if(!p) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
