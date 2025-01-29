package solutions;

public class redundant_connection {

	public int find(int[] groups, int i) {
		if(groups[i] == i) return i;
		return find(groups, groups[i]);
	}

	public int[] findRedundantConnection(int[][] edges) {
		int[] groups = new int[edges.length];
		for(int i = 0; i < groups.length; i++) groups[i] = i;

		for(int[] e: edges) {
			int left = find(groups, e[0] - 1);
			int right = find(groups, e[1] - 1);

			if(left == right) return e;
			groups[left] = right;
		}


		return null;
	}
}
