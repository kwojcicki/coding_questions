package solutions;

public class zero_array_transformation_ii {
	public int minZeroArray(int[] nums, int[][] queries) {
        int[] cnt = new int[nums.length + 1];

		int line = 0;
		int index = 0;
		for(int qIndex = 0; qIndex <= queries.length; qIndex++) {

            for(int i = index; i < nums.length; i++) {
				if(nums[i] > line) break;
				line += cnt[i + 1];
                index++;
			}

            if(index == nums.length) return qIndex;
            if(qIndex == queries.length) return -1;

			int[] q = queries[qIndex];
			cnt[q[0]] += q[2];
			cnt[q[1] + 1] -= q[2];
			
			if(index >= q[0] && index <= q[1]) line += q[2];
		}

		return -1;
	}
}
