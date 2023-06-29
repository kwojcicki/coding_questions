package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class find_k_pairs_with_smallest_sums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> ret = new ArrayList<>();
		int l = 0, r = 0;

		Queue<int[]> q = new PriorityQueue<>((a,b) -> {
			return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
		});

		q.add(new int[] {0, 0});

		while(ret.size() != k && !q.isEmpty()) {
			int[] n = q.poll();
			
			ret.add(Arrays.asList(nums1[n[0]], nums2[n[1]]));
			if(n[0] + 1 < nums1.length && n[1] + 1 < nums2.length) {
				q.add(new int[] {n[0] + 1, n[1] + 1});
			}

			if(n[0] == l && l + 1 < nums1.length) {
				q.add(new int[] {++l, 0});
			}
			if(n[1] == r && r + 1 < nums2.length) {
				q.add(new int[] {0, ++r});
			}
		}

		return ret;
	}
}
