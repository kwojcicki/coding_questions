package solutions;

import java.util.TreeMap;

public class data_stream_as_disjoint_intervals {
	class SummaryRanges {

		TreeMap<Integer, int[]> map = new TreeMap<>();
		public SummaryRanges() {

		}

		public void addNum(int value) {
			if(map.containsKey(value)) return;
			Integer l = map.lowerKey(value);
			Integer h = map.higherKey(value);

			if(l != null && h != null && map.get(l)[1] + 1 == value && 
					value + 1 == h) {
				map.get(l)[1] = map.get(h)[1];
				map.remove(h);
			} else if(l != null && map.get(l)[1] + 1 >= value) {
				map.get(l)[1] = Math.max(map.get(l)[1], value);
			}  else if(h != null && h == value + 1) {
				map.put(value, new int[] {value, map.get(h)[1]});
				map.remove(h);
			} else {
				map.put(value, new int[] { value, value});
			}
		}

		public int[][] getIntervals() {
			return map.values().toArray(new int[map.size()][2]);
		}
	}

}
