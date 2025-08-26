package solutions;

public class maximum_area_of_longest_diagonal_rectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        double diagnol = 0;
        
        for(int[] i: dimensions) {
        	double d = i[0] * i[0] + i[1] * i[1];
        	if(d > diagnol) {
        		diagnol = d;
        		area = i[0]* i[1];
        	} else if(d == diagnol) {
        		area = Math.max(i[0] * i[1], area);
        	}
        }
        
        return area;
    }
}
