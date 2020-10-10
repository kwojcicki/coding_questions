package solutions;

import java.util.Arrays;

public class minimum_number_of_arrows_to_burst_balloons {
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a,b)->{
			return Integer.compare(a[1], b[1]);
		});


		//         for(int[] a: points){
		//             System.out.println(Arrays.toString(a));
		//         }

		int overlapping = 0;
		Integer max = null;

		for(int i = 0; i < points.length; i++) {
			if(max != null && points[i][0] <= max && max <= points[i][1]) {
				overlapping++;
			} else {
				max = points[i][1];
			}
		}



		return points.length - overlapping;
	}
}
