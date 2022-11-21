package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class nearest_exit_from_entrance_in_maze {
	public int nearestExit(char[][] maze, int[] entrance) {
		int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

		Queue<int[]> q = new LinkedList<>();
		q.add(entrance);
		int lvl = 0;
		while(!q.isEmpty()) {
			for(int i = q.size() - 1; i >= 0; i--) {
				int[] n = q.poll();
				int x = n[0];
				int y = n[1];
				if((x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) && (x != entrance[0] || y != entrance[1])) return lvl;

				for(int[] dir: dirs) {
					int x1 = x + dir[0];
					int y1 = y + dir[1];
					if(x1 < 0 || x1 >= maze.length || y1 < 0 || y1 >= maze[0].length ||
							maze[x1][y1] == '+') continue;
					maze[x1][y1] = '+';
					q.add(new int[] {x1, y1});
				}

			}
			lvl++;
		}

		return -1;
	}
}
