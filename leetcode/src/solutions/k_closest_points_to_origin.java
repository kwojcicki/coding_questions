package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class k_closest_points_to_origin {

	public int[][] kClosest(int[][] points, int K){
		if(K == 1) {
			return new int[][] { Arrays.stream(points).min((i,j) -> Integer.compare(i[0] * i[0] + i[1] * i[1], j[0] * j[0] + j[1] * j[1])).get() };
		} else if(K * 4 < points.length) {
			kClosest1(points, K);
		}
		
		return kClosest2(points, K);
	}

	public int[][] kClosest2(int[][] points, int K) {
		Arrays.sort(points, (i, j) -> {
			return Integer.compare(i[0] * i[0] + i[1] * i[1], j[0] * j[0] + j[1] * j[1]);
		});

		return Arrays.copyOfRange(points, 0, K);
	}

	public int[][] kClosest1(int[][] points, int K){
		PriorityQueue<int[]> q = new PriorityQueue<>((i,j)->{
			return - Integer.compare(i[0] * i[0] + i[1] * i[1], j[0] * j[0] + j[1] * j[1]);
		});

		for(int[] point: points) {
			if(q.size() < K) {
				q.add(point);
				continue;
			}

			int distance = point[0] * point[0] + point[1] * point[1];
			int[] compare = q.peek();
			if(compare[0] * compare[0] + compare[1] * compare[1] > distance) {
				q.poll();
				q.add(point);
			}
		}

		int[][] ret = new int[K][2];

		for(int i = 0; i < K; i++) {
			ret[i] = q.poll();
		}

		return ret;
	}
}
