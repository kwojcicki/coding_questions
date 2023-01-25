package solutions;

public class find_closest_node_to_given_two_nodes {
	public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n1 = node1;
        int n2 = node2;

        while(n1 >= 0 || n2 >= 0){
            if(n1 == n2) return n1;
            if(n1 >= 0 && n2 >= 0 && edges[n1] == -3 && edges[n2] == -2) return n1 > n2 ? n2 : n1;
            if(n1 >= 0 && edges[n1] == -3) return n1;
            if(n2 >= 0 && edges[n2] == -2) return n2;

            if(n1 >= 0){
                int t1 = edges[n1];
                edges[n1] = -2;
                n1 = t1;
            }
            if(n2 >= 0){
                int t2 = edges[n2];
                edges[n2] = -3;
                n2 = t2;
            }

        }
        
        return -1;
    }
}
