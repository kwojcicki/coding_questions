package misc;

import java.util.Arrays;

public class misc {

	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,10,11,12};
		int[] B = new int[] {4,5,6,7,8,9};
		
		System.out.println(median(A, B));
		
		A = new int[] {1,2,3,4,5,6};
		B = new int[] {7,8,9,10,11,12};
		
		System.out.println(median(A, B));
	}
	
	public static double median(int A[], int B[]) {
		int i = 0;
		int j = 0;
		int w = 6;
		while(w > 2) {
			int k = (int)Math.floor((double) (w - 1) / 2);
			
			System.out.println("Comparing: " + A[i + k] + " and " + B[j + k]);
			if(A[i+k] < B[j + k]) {
				System.out.println("Less");
				i = i + k;
			} else {
				System.out.println("More");
				j = j + k;
			}
			
			w = w - k;
		}
		
		int[] tmp = new int[4];
		tmp[0] = A[i];
		tmp[1] = A[i + w - 1];
		tmp[2] = B[j];
		tmp[3] = B[j + w - 1];
		System.out.println(":" + Arrays.toString(tmp));
		Arrays.sort(tmp);
		System.out.println(Arrays.toString(tmp));
		return (double)(tmp[1] + tmp[2]) / 2;
		
	}
	
}
