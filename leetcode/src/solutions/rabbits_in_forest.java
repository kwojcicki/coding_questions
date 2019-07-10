package solutions;

import java.util.HashMap;
import java.util.Map;

public class rabbits_in_forest {
	public int numRabbits(int[] answers) {
		int ret = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i: answers) {

			if(i == 0) {
				ret++;
			} else if(map.containsKey(i) && map.get(i) >= 1) {

				map.put(i, map.get(i) - 1);
				ret++;

			} else {
				ret += 1;
				map.put(i, i);
			}
		}

		for(int i: map.values()) {
			if(i > 0) {
				ret +=i ;
			}
		}

		return ret;
	}
}
