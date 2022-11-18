package solutions;

public class rectangle_area {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if(ax1 > bx1) return computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        
        int ret = (ax2 - ax1) * (ay2 - ay1) + 
        			(bx2 - bx1) * (by2 - by1);
        
        if(by2 < ay1 || 
        		ay2 < by1 || 
        		bx1 > ax2) {
        	return ret;
        }
        
        int overlap = 0;
        
        int left = bx1;
        int right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        overlap = (right - left) * (top - bottom);
        return ret - overlap;
    }
}
