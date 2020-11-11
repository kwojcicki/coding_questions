package solutions;

public class valid_square {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = new int[][] { p1, p2, p3 ,p4 };
        return helper(p, 0);
    }
    
    public int dist(int[] p1, int[] p2) {
    	return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]); 
    }
    
    public boolean check(int[][] p) {
    	return dist(p[0], p[1]) == dist(p[2], p[3]) && dist(p[0], p[2]) == dist(p[1], p[3]) && 
    			dist(p[0], p[3]) == dist(p[1], p[2]) && dist(p[0], p[2]) == dist(p[0], p[1]) && dist(p[0], p[1]) > 0;
    }
    
    public boolean helper(int[][] p, int start) {
    	if(start == p.length - 1) {
    		return check(p);
    	}
    	
    	int[] tmp;
    	boolean res = false;
    	for(int i = start; i < p.length - 1; i++) {
    		tmp = p[i];
    		p[i] = p[i + 1];
    		p[i + 1] = tmp;
    		
    		res |= helper(p, i + 1);
    		
    		tmp = p[i];
    		p[i] = p[i + 1];
    		p[i + 1] = tmp;
    	}
    	
    	return res;
    }
}
