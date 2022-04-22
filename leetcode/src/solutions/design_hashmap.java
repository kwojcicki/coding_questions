package solutions;

import java.util.Arrays;

public class design_hashmap {
	class MyHashMap {
		int[] seen = new int[(int) (Math.pow(10, 6) + 1)];

		public MyHashMap() {
			Arrays.fill(seen, -1);
		}

		public void put(int key, int value) {
			seen[key] = value;
		}

		public int get(int key) {
			return seen[key];
		}

		public void remove(int key) {
			seen[key] = -1;
		}
	}
}
