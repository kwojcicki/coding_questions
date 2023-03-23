package solutions;

public class number_of_operations_to_make_network_connected {
	
	public int find(int[] f, int x) {
		return f[x] == x ? x : find(f, f[x]);
	}
	
    public int makeConnected(int n, int[][] connections) {
        int[] f = new int[n];
        for(int i = 0; i < f.length; i++) f[i] = i;
        
        int extra = 0;
        int islands = n;
        
        for(int[] c: connections) {
        	int x = find(f, c[0]);
        	int y = find(f, c[1]);
        	if(x == y) {
        		extra++;
        	} else {
        		islands--;
        		f[x] = y;
        	}
        }
        
        return islands - 1 <= extra ? islands - 1 : -1;
    }
}
