package solutions;

public class first_completely_painted_row_or_column {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[][] map = new int[arr.length + 1][2];
        
        for(int i = 0; i < mat.length; i++) {
        	for(int j = 0; j < mat[i].length; j++) {
        		map[mat[i][j]][0] = i;
        		map[mat[i][j]][1] = j;
        	}
        }
        
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        
        for(int i = 0; i < arr.length; i++) {
        	int r = map[arr[i]][0];
        	int c = map[arr[i]][1];
        	rows[r]++;
        	if(rows[r] == mat[0].length) return i;
        	cols[c]++;
        	if(cols[c] == mat.length) return i;
        }
        
        return -1;
    }
}
