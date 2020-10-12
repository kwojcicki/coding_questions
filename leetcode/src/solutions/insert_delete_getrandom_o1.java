package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class insert_delete_getrandom_o1 {
	class RandomizedSet {

		Random r;
		Map<Integer, Integer> map;
		List<Integer> l;
		/** Initialize your data structure here. */
		public RandomizedSet() {
			r = new Random();
			map = new HashMap<Integer, Integer>();
			l = new ArrayList<>();
		}

		/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		public boolean insert(int val) {
			if(map.containsKey(val)) return false;
			l.add(val);
			map.put(val, l.size() - 1);
			return true;
		}

		/** Removes a value from the set. Returns true if the set contained the specified element. */
		public boolean remove(int val) {
			if(!map.containsKey(val)) return false;

			Collections.swap(l, map.get(val), l.size() - 1);

			map.put( l.get(map.get(val)), map.get(val) );

			l.remove(l.size() - 1);
			map.remove(val);

			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			return l.get(r.nextInt(l.size()));
		}
	}
}
