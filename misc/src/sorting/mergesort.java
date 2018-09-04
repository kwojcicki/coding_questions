package sorting;

import java.util.Arrays;

public class mergesort {

	
	public static void main(String[] args) {
		int[] arr = new int[] { 5, -1, 10, 2 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		mergesortHelper(arr, 0, arr.length - 1);
	}
	
	public static void mergesortHelper(int[] arr, int low, int high) {
		if(low < high) {
			mergesortHelper(arr, low, high / 2);
			mergesortHelper(arr, high / 2 + 1, high);
			merge(arr, low, high);
		}
	}
	
}
