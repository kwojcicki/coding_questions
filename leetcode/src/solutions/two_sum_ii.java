package solutions;

public class two_sum_ii {
	public int[] twoSum(int[] numbers, int target) {
		int index = 0;
		int index1 = numbers.length - 1;

		while(true) {
			if(numbers[index] + numbers[index1] == target) {
				break;
			} else if(numbers[index] + numbers[index1] > target) {
				index1--;
			} else {
				index++;
			}
		}

		return new int[] { index + 1, index1 + 1};
	}
}
