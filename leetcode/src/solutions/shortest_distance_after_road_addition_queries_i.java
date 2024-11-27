package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class shortest_distance_after_road_addition_queries_i {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ret = new int[queries.length];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i + 1);
            graph.add(tmp);
        }

        for(int i = 0; i < queries.length; i++){
            graph.get(queries[i][0]).add(queries[i][1]);

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            int hops = -1;
            q.add(0);
            outerloop: while(!q.isEmpty()){
                hops++;
                for(int nList = q.size(); nList > 0; nList--){
                    int node = q.poll();
                    if(node == n - 1) break outerloop;
                    for(int neighbor: graph.get(node)) {
                        if(seen.add(neighbor)) q.add(neighbor);
                    }
                }
            }

            ret[i] = hops;
        }

        return ret;
    }
}
