package sorting;

import java.util.Arrays;

public class mergesort {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 5, -1, 10, 2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] { 5, -1, 10, 2, 3, -10, 11};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		mergesortHelper(arr, 0, arr.length - 1);
	}
	
	public static void mergesortHelper(int[] arr, int low, int high) {
		if(low < high) {
			mergesortHelper(arr, low, (low + high) / 2);
			mergesortHelper(arr, (low + high) / 2 + 1, high);
			merge(arr, low, high);
		}
	}
	
	public static void merge(int[] arr, int low, int high) {
		int[] temp = new int[arr.length];
		for(int i = low; i <= high; i++) {
			temp[i] = arr[i];
		}
		
		int leftHelper = low;
		int middle = (low + high) / 2;
		int rightHelper = middle + 1;
		int current = low;
		while(leftHelper <= middle && rightHelper <= high) {
			
			if(temp[leftHelper] <= temp[rightHelper]) {
				arr[current] = temp[leftHelper];
				leftHelper++;
			} else {
				arr[current] = temp[rightHelper];
				rightHelper++;
			}
			
			current++;
		}
		
		int remaining = middle - leftHelper;
		for(int i = 0; i <= remaining; i++) {
			arr[current + i] = temp[leftHelper + i];
		}
		
		System.out.println("arr: " + Arrays.toString(arr));
	}
}
