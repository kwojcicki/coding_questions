package solutions;

public class swim_in_rising_water {
    public int swimInWater(int[][] grid) {
        int ret = 0;
        int[][] dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        Queue<int[]> q = new PriorityQueue<>((a,b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        q.add(new int[]{0, 0});
        grid[0][0] = -grid[0][0];
        while(!q.isEmpty()){
          int[] n = q.poll();
          int x = n[0], y = n[1];
          // System.out.println(x + " " + y + " " + grid[x][y]);
          ret = Math.max(ret, grid[x][y] * -1);
          if(x == grid.length - 1 && y == grid[0].length - 1) return ret;
          for(int[] dir: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] < 0) continue;
            grid[newX][newY] = -grid[newX][newY];
            q.add(new int[]{newX, newY});
          }
        }

        return ret;
    }
}
