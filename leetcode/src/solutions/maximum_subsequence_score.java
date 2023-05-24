package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class maximum_subsequence_score {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long ret = 0;
        int[][] nu = new int[nums1.length][2];
        for(int i = 0; i < nums1.length; i++) {
        	nu[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(nu, (a,b) -> Integer.compare(b[1], a[1]));
        Queue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        long sum = 0;
        for(int[] n: nu) {
        	sum += n[0];
        	q.add(n);
        	if(q.size() > k) sum -= q.poll()[0];
        	if(q.size() == k) {
        		ret = Math.max(ret, sum * n[1]);
        	}
        }
        
        
        return ret;
    }
}
