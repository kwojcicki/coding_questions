package solutions;

public class maximize_distance_to_closest_person {

	public int maxDistToClosest(int[] seats) {
        int ret = 0;
		int start = -1;
		
		for(int i = 0; i < seats.length; i++) {
			if(seats[i] == 1) {
                if(start == -1){ 
				    ret = Math.max(ret, i);
                } else {
				    ret = Math.max(ret, (i - start) / 2);
                }
				start = i;
			}
		}

		return Math.max(ret, (seats.length - start - 1));
    }

	public int maxDistToClosest1(int[] seats) {
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
