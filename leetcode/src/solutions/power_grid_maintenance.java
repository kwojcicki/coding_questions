package solutions;

public class power_grid_maintenance {
    public int find(int[] f, int x){
        if(f[x] == x) return x;
        f[x] = find(f, f[x]);
        return f[x];
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] f = new int[c + 1];
        boolean[] on = new boolean[c + 1];
        Arrays.fill(on, true);
        for(int i = 0; i < f.length; i++) f[i] = i;
        for(int[] conn: connections){
            int x = find(f, conn[0]);
            int y = find(f, conn[1]);
            if(x != y){
                f[x] = y;
            }
        }
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 1; i < f.length; i++){
            int x = find(f, i);
            map.computeIfAbsent(x, (k) -> new PriorityQueue<Integer>()).add(i);
        }

        int numQueries = 0;
        for(int[] q: queries) if(q[0] == 1) numQueries++;
        int[] ret = new int[numQueries];
        int idx = 0;

        for(int[] q: queries){
            if(q[0] == 1){
                if(on[q[1]]) {
                    ret[idx++] = q[1];
                } else {
                    int x = find(f, q[1]);
                    Queue<Integer> que = map.get(x);

                    while(que != null && !que.isEmpty() && !on[que.peek()]) que.poll();

                    ret[idx++] = que.isEmpty() ? -1 : que.peek();
                }
            } else {
                on[q[1]] = false;
            }
        }

        return ret;
    }
}
