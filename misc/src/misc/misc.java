package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class misc {

	public static void main(String[] args) {

		Set<List<Integer>> poss = new HashSet<>();
		List<Integer> l1 = Arrays.asList(-100_000, -100_001, -100_003);
		List<Integer> l2 = Arrays.asList(-100_000, -100_001, -100_003);
		System.out.println(l1 + " " + l2 + " " + l1.equals(l2));
		poss.add(Arrays.asList(-100_000, -100_001, -100_003));
		poss.add(Arrays.asList(-100_000, -100_001, -100_003));
		System.out.println(poss.size()); // 1
		System.out.println(System.identityHashCode(l1));
		System.out.println(System.identityHashCode(l2));
		
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < 8; i++) {
				System.out.println("convert -crop 8x8" + "+" + (i * 8) + "+" + (j * 8) + " .\\revolution_tiles.png tile" + (i + j * 8) + ".png");
			}
		}
		
		final int startInclusive = 0;
		final int endExclusive = 2;
		IntStream.range(startInclusive, endExclusive).boxed().collect(Collectors.toSet());

		int[] A = new int[] {1,2,3,10,11,12};
		int[] B = new int[] {4,5,6,7,8,9};

		//		System.out.println(median(A, B));
		//		
		//		A = new int[] {1,2,3,4,5,6};
		//		B = new int[] {7,8,9,10,11,12};
		//		
		//		System.out.println(median(A, B));
		//		
		//		A = new int[] {1,2};
		//		B = new int[] {7,8};
		//		
		//		System.out.println(median(A, B));

		A = new int[] {1};
		B = new int[] {7};

		System.out.println(median(A, B));
	}

	public static double median(int A[], int B[]) {
		int i = 0;
		int j = 0;
		int w = 1;
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
		System.out.println(":" + Arrays.toString(tmp) + " " + w);
		Arrays.sort(tmp);
		System.out.println(Arrays.toString(tmp));
		return (double)(tmp[1] + tmp[2]) / 2;

	}

}
