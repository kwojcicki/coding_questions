package solutions;

public class minimum_time_to_make_rope_colorful {
	public int minCost(String colors, int[] neededTime) {
		char[] c = colors.toCharArray();
		if(c.length == 1) return 0;
		char prev = c[0];
		int lastVal = neededTime[0];
		int ret = 0;
		for(int i = 1; i < c.length; i++) {
			if(c[i] == prev) {
				ret += Math.min(lastVal, neededTime[i]);
				lastVal = Math.max(lastVal, neededTime[i]);
				// System.out.println(lastVal + " " + ret);
			} else {
				prev = c[i];
				lastVal = neededTime[i];
			}
		}

		return ret;
	}
}
