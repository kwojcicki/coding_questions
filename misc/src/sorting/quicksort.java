package sorting;

import java.util.Arrays;

public class quicksort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {0,1,2,20,3,21,4};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] { 5, -1, 10, 2, 3, -10, 11};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		quicksortHelper(arr, 0, arr.length - 1);
	}
	
	public static void quicksortHelper(int[] arr, int left, int right) {
		System.out.println(left + " " + right);
		int index = partition(arr, left, right);
		if(left < index - 1) {
			quicksortHelper(arr, left, index - 1);
		}
		
		if(index < right) {
			quicksortHelper(arr, index, right);
		}
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		
		while(left <= right) {
			
			while(arr[left] < pivot) left++;
			
			while(arr[right] > pivot) right--;
			
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
			
		}
		System.out.println(left);
		return left;
	}
	
	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		System.out.println(Arrays.toString(arr));
	}
}
