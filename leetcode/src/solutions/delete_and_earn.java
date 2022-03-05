package solutions;

public class delete_and_earn {
	public int deleteAndEarn(int[] nums) {

		int[] vals = new int[10_001];

		for(int i: nums) {
			vals[i] += i;
		}

		int oneStep = 0;
		int twoStep = 0;
		int tmp;

		for(int i: vals) {
			tmp = oneStep;
			oneStep = Math.max(twoStep + i, oneStep);
			twoStep = tmp;
		}

		return Math.max(oneStep, twoStep);
	}

}
