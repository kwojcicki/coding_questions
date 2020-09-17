package solutions;

public class robot_bounded_in_circle {
    public boolean isRobotBounded(String instructions) {
    	if(instructions.indexOf('G') == -1) return true;
    	
    	int[][] directions = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    	int dir = 0;
    	int x = 0, y = 0;
    	
    	for(char c: instructions.toCharArray()) {
    		if(c == 'G') {
    			x += directions[dir][0];
    			y += directions[dir][1];
    		} else if(c == 'L') {
    			dir = (dir + 3) % 4;
    		} else {
    			dir = (dir + 1) % 4;
    		}
    	}
    	
    	return (x == y && x == 0) || dir != 0;
    }
}
