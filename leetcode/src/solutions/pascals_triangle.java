package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pascals_triangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(Arrays.asList(1));

		for(int i = 1; i < numRows; i++) {
			List<Integer> r = new ArrayList<>();
			List<Integer> prev = ret.get(ret.size() - 1);
            r.add(1);
			for(int j = 1; j < i; j++) {
				r.add(prev.get(j) + prev.get(j - 1));
			}
            r.add(1);
			ret.add(r);
		}

		return ret;
	}
}
