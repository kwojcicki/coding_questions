package solutions;

public class minimum_time_to_complete_trips {
	public long minimumTime(int[] time, int totalTrips) {
		long start = 0;
		long end = time[0] * (long) totalTrips;

		while(start < end) {
			long mid = (end + start) / 2;

			long t = 0;
			for(int i: time) {
				t += mid / i;
			}

			// System.out.println(start +  " " + end + " " + mid + " " + t);
			if(t >= totalTrips) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		// System.out.println(start +  " " + end);
		return start;
	}
}
