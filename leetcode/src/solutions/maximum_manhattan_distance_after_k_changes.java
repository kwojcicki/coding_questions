package solutions;

public class maximum_manhattan_distance_after_k_changes {
    public int maxDistance(String s, int k) {
        int ret = 0;
        int north = 0, east = 0, south = 0, west = 0;
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(c == 'N') north++;
        	else if(c == 'E') east++;
        	else if(c == 'S') south++;
        	else if(c == 'W') west++; 
        	
        	int vertical = Math.abs(north - south);
        	int horizontal = Math.abs(west - east);
        	
        	int dist = vertical + horizontal;
        	ret = Math.max(
        			ret, 
        			dist + Math.min(2 * k, i + 1 - dist)
        		);
        }
        
        return ret;
    }
}
