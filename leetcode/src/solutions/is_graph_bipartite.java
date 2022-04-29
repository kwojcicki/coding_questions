package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class is_graph_bipartite {
	public boolean isBipartite(int[][] graph) {
		boolean[] a = new boolean[graph.length];
		boolean[] b = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();

		for(int i = 0; i < graph.length; i++) {
			int color = -1;

			if(a[i] || b[i]) continue;
			// System.out.println(i);
			q.add(i);

			while(!q.isEmpty()) {

				
				for(int size = q.size() - 1; size >= 0; size--) {
					Integer n = q.poll();
 
					if(color == -1) {
						a[n] = true;
					} else {
						b[n] = true;
					}

					int tmpColor = - color;
					// System.out.println(aSet);
					// System.out.println(bSet);
					for(int edge: graph[n]) {
						//System.out.println(n + " " + edge);
						if(tmpColor == -1 && b[edge]) return false;
						if(tmpColor == 1 && a[edge]) return false;
						if(a[edge] || b[edge]) continue;
						q.add(edge);
					}
				}
				
				color = - color;
			}
		}

		return true; 
	}
}
