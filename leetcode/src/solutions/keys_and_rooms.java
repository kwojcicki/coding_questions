package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class keys_and_rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	 boolean[] visited = new boolean[rooms.size()];
         int c = 0;
         Queue<Integer> q = new LinkedList<>();
         q.add(0);
         visited[0] = true;
         while(!q.isEmpty()) {
         	int n = q.poll();
         	c++;
         	for(int ne: rooms.get(n)) {
         		if(!visited[ne]) {
         			q.add(ne);
         			visited[ne] = true;
         		}
         	}
         }
         
         return c == rooms.size(); 
    }
}
