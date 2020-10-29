package solutions;

public class maximize_distance_to_closest_person {
	public int maxDistToClosest(int[] seats) {
		int max = 0;

		int start = 0;
		int end = 0;
		boolean first = true;

		while(end != seats.length) {
			if(seats[end] == 1) {
				if(first){
					max = (end);
					first = false;
				} else {
					max = Math.max(max, (end - start) / 2);   
				}
				start = end;
			}
			end++;
		}

		max = Math.max(max, (end - start - 1));
		return max;
	}
}
