package solutions;
class maximum_path_score_in_a_grid {
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k + 1];
        for(int[][] i: dp) for(int[] j: i) Arrays.fill(j, -2);
        int ret = recurse(0, 0, dp, grid, k);
        // for(int[][] i: dp) for(int[] j: i) System.out.println(Arrays.toString(j));
        return ret;
    }

    public int recurse(int x, int y, int[][][] dp, int[][] grid, int k){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || k - Math.min(grid[x][y], 1) < 0) return -1;
        if(dp[x][y][k] >= 0) return dp[x][y][k];
        if(dp[x][y][k] == -1) return -1;
        if(x == grid.length - 1 && y == grid[0].length - 1) return grid[x][y];
        int left = recurse(x + 1, y, dp, grid, k - Math.min(grid[x][y], 1));
        int right = recurse(x, y + 1, dp, grid, k - Math.min(grid[x][y], 1));
        int best = Math.max(
            left, right
        );

        if(best < 0) dp[x][y][k] = -1;
        else dp[x][y][k] = best + grid[x][y];
        // best += grid[x][y];

        // for(int k1 = k; k1 < dp[x][y].length; k1++){
        //     dp[x][y][k1] = Math.max(dp[x][y][k1], best);
        // }

        return dp[x][y][k];
    }
}
