package solutions;

import java.util.HashMap;
import java.util.Map;

public class fruit_into_baskets {
	public int totalFruit(int[] fruits) {
		int ret = 0;

		Map<Integer, Integer> m = new HashMap<>();

		int start = 0;
		for(int i: fruits) {
			m.compute(i, (k,v) -> v == null ? 1 : v + 1);
			while(m.size() > 2) {
				if(m.compute(fruits[start], (k,v) -> v - 1) == 0) {
					m.remove(fruits[start]);
				}
				start++;
			}
			ret = Math.max(ret, m.values().
					stream().reduce(0, (a,b) -> a + b));
		}

		return ret;
	}
}
