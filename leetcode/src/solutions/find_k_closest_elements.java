package solutions;

import java.util.ArrayList;
import java.util.List;

public class find_k_closest_elements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> a = new ArrayList<>(arr.length);
		for(int i: arr) a.add(i);
		int low = 0; int high = arr.length - k;
		while(low < high) {
			int mid = (high + low) / 2;
			if(x - arr[mid] > arr[mid + k] - x) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		
		return a.subList(low, high);
	}

	public static void main(String[] args) {
		find_k_closest_elements t = new find_k_closest_elements();
		System.out.println(t.findClosestElements(new int[] {1,1,1,10,10,10},
				1,
				9));
		System.out.println("[10]");
		
		System.out.println(t.findClosestElements(new int[] {1,2,3,4,5},
				4,
				-1));
		System.out.println("[1,2,3,4]");
		
		System.out.println(t.findClosestElements(new int[] {0,0,1,2,3,3,4,7,7,8},
				3,
				5));
		System.out.println("[3,3,4]");
	}
}
