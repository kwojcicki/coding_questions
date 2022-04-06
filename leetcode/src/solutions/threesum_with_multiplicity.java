package solutions;

import java.util.Arrays;

public class threesum_with_multiplicity {
	public int threeSumMulti(int[] arr, int target) {
		int ret = 0;
		Arrays.sort(arr);

		int modulo = (int) (Math.pow(10, 9) + 7);

		for(int i = 0; i < arr.length; i++) {
			int t = target - arr[i];
			int start = i + 1;
			int end = arr.length - 1;

			while(start < end) {

				if(arr[start] + arr[end] > t) end--;
				else if(arr[start] + arr[end] == t){ 
					int oldIndex = start;
					int oldStart = arr[start];
					int oldEnd = arr[end];
					int left = 0, right = 0;
					while(start < arr.length && oldStart == arr[start] && start <= end) { start++; left++; }
					while(oldEnd == arr[end] && end >= start) { end--; right++; }
					if(oldStart == oldEnd) { 
						int n = start - oldIndex;
						// System.out.println(n);
						ret = (ret + (n) * (n-1) / 2) % modulo;
						// System.out.println(start - oldIndex); 
					}
					else { 
						ret = (ret + (left * right)) % modulo; 
						// System.out.println(left + " " + right); 
					}
				}
				else start++;
			}
			// System.out.println(ret + "---");
		}

		return ret;
	}
}
