package solutions;

public class capacity_to_ship_packages_within_d_days {
	public boolean check(int[] weights, int weight, int days) {
		int curr = weight;
		for(int i = 0; i < weights.length; i++) {
			// System.out.println("- " + i + " " + curr + " " + days);
			if(weights[i] > weight) return false;
			if(curr - weights[i] >= 0) curr -= weights[i];
			else {
				curr = weight - weights[i];
				days--;
			}
			if(days == 0) return false;
		}

		return true;
	}

	public int shipWithinDays(int[] weights, int days) {
		int start = 1;
		int end = 500 * weights.length / days;

		while(start < end) {
			int mid = (end - start) / 2 + start;
			// System.out.println(start + " " + end);
			if(check(weights, mid, days)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}
}
