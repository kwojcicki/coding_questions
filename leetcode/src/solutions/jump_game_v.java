package solutions;

class jump_game_v {
    public int maxJumps(int[] arr, int d) {
        int ret = 0;
        Queue<Integer> q = new PriorityQueue<Integer>((a,b) -> arr[a] - arr[b]);
        for(int i = 0; i < arr.length; i++) q.add(i);
        int[] dp = new int [arr.length];
        Arrays.fill(dp, 1);

        while(!q.isEmpty()){
            int n = q.poll();
            int min = arr[n];
            int i = n - 1;
            while(i >= 0 && arr[i] < min && n - i <= d){ dp[n] = Math.max(dp[n], dp[i] + 1); i--; }
            i = n + 1;
            while(i < arr.length && arr[i] < min && i - n <= d){ dp[n] = Math.max(dp[n], dp[i] + 1); i++; }
            ret = Math.max(ret, dp[n]);
            // System.out.println(n + " " + dp[n]);
        }

        // System.out.println(Arrays.toString(dp));

        return ret;
    }
}
