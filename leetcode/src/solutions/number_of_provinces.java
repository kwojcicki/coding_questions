package solutions;

public class number_of_provinces {
	public int find(int[] f, int i) {
		return i == f[i] ? i : find(f, f[i]);
	}

	public int findCircleNum(int[][] isConnected) {
		int islands = isConnected.length;
		int[] f = new int[isConnected.length];
		for(int i = 0; i < f.length; i++)
			f[i] = i;

		for(int i = 0; i < isConnected.length; i++) {
			for(int j = i + 1; j < isConnected.length; j++) {
				if(isConnected[i][j] == 1) {
					int x = find(f, i);
					int y = find(f, j);

					if(x != y) {
						islands--;
						f[x] = y;
					}
				}
			}
		}

		return islands;
	}
}
