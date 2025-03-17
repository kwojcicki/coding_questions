package solutions;

public class minimum_operations_to_make_array_equal {
	// n = 6
	// 1 3 5 7 9 11
	public int minOperations(int n) {
		int ret = 0;
		int tar = 0;
		// probably can do this in O(1)
		for(int i = 1; i < (n * 2); i += 2) tar += i;
		tar /= n;
		for(int i = 1; i < n; i += 2) ret += tar - i;

		return ret;
	}
}
