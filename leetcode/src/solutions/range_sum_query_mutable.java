package solutions;

public class range_sum_query_mutable {

	class NumArray {

		int[] bit;
		int[] nums;
		public NumArray(int[] nums) {
			bit = new int[nums.length + 1];
			for(int i = 0; i < nums.length; i++) {
				set(i, nums[i]);
			}
			this.nums = nums;
		}

		private int getNext(int i) {
			return i + (i & (-i));
		}

		private int getParent(int i) {
			return i - (i & (-i));
		}

		public void update(int index, int val) {
			set(index, val - nums[index]);
			nums[index] = val;
		}

		private void set(int index, int val) {
			++index;
			while(index < bit.length) {
				bit[index] += val;
				index = getNext(index);
			}
		}

		public int sumRange(int left, int right) {
			return sum(right) - (left > 0 ? sum(left - 1) : 0);
		}

		private int sum(int i) {
			int sum = 0;
			++i;
			while (i > 0) {
				sum += bit[i];
				i = getParent(i);
			}
			return sum;
		}
	}

	class NumArray1 {
		SegNode root = null;
		public NumArray1(int[] nums) {
			root = create(0, nums.length - 1, nums);
		}

		class SegNode {
			public SegNode(int start, int end, int value) {
				this.start = start; this.end = end; this.value = value;
			}
			public int value;
			public SegNode left;
			public SegNode right;
			public int start;
			public int end;
		}

		public SegNode create(int start, int end, int[] nums) {
			// System.out.println(start + " " + end);
			if(start == end) {
				return new SegNode(start, end, nums[start]);
			}

			int mid = (end - start) / 2 + start;
			SegNode tmp = new SegNode(start, end, 0);
			tmp.left = create(start, mid, nums);
			tmp.right = create(mid + 1, end, nums);

			tmp.value = tmp.left.value + tmp.right.value;
			// System.out.println(start + " " + end + " " + tmp.value);
			return tmp;
		}

		public void update(int index, int val) {
			updateHelper(index, val, root);
		}

		public int updateHelper(int index, int val, SegNode root) {
			if(root.start == index && root.end == index) {
				int diff = val - root.value;
				root.value = val;
				return diff;
			}

			int diff = updateHelper(index, val, index > root.left.end ? 
					root.right :
						root.left);
			root.value += diff;
			return diff;
		}

		public int sumRange(int left, int right) {
			return sumRangeHelper(left, right, root);
		}

		public int sumRangeHelper(int start, int end, SegNode root) {
			// System.out.println(start + " " + end + " " + root.start + " " + root.end);
			if(root.start == start && root.end == end) return root.value;

			int ret = 0;
			if(root.right != null && end >= root.right.start) ret += sumRangeHelper(Math.max(root.right.start, start), end, root.right);
			if(root.left != null && start <= root.left.end) ret += sumRangeHelper(start, Math.min(root.left.end, end), root.left);
			return ret;
		}
	}
}
