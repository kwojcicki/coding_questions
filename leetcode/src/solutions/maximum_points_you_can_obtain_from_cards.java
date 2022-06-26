package solutions;

public class maximum_points_you_can_obtain_from_cards {
	public int maxScore(int[] cardPoints, int k) {
		int ret = 0;
		int curr = 0;

		for(int i = 0; i < k; i++) {
			curr += cardPoints[i];
		}

		ret = curr;
		if(k == cardPoints.length) return curr;
		// System.out.println(curr);
		for(int i = k - 1; i >= 0; i--) {
			curr -= cardPoints[i];
			curr += cardPoints[cardPoints.length - (k - i)];
			// System.out.println(curr);
			ret = Math.max(ret, curr);
		}

		return ret;
	}
}
