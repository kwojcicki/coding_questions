package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class snapshot_array {
	class SnapshotArray {

		int s = 0;
		List<TreeMap<Integer, Integer>> l = new ArrayList<>();
		public SnapshotArray(int length) {
			for(int i = 0; i < length; i++) {
				l.add(new TreeMap<Integer, Integer>());
				l.get(i).put(0, 0);
			}
		}

		public void set(int index, int val) {
			l.get(index).put(s, val);
		}

		public int snap() {
			return s++;
		}

		public int get(int index, int snap_id) {
			return l.get(index).floorEntry(snap_id).getValue();
		}
	}
}
