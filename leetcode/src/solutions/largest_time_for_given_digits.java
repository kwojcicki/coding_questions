package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class largest_time_for_given_digits {

	static int maxTime = -1; 
	
	public static String largestTimeFromDigits(int[] A) {
		permuate(Arrays.stream(A).boxed().collect(Collectors.toList()), 0);
		
		if(maxTime == -1) {
			return "";
		} else {
			return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
		}
	}
	
	public static void permuate(List<Integer> A, int start) {
		if(start == A.size()) {
			int hour = A.get(0) * 10 + A.get(1);
			int min = A.get(2) * 10 + A.get(3);
			
			if(hour < 24 && min < 60) {
				maxTime = Math.max(maxTime, hour * 60 + min);
			}
			
			return;
		}
		
		for(int i = start; i < A.size(); i++) {
			Collections.swap(A, i, start);
			permuate(A, start + 1);
			Collections.swap(A, i, start);
		}
	}
	
    public static void main(String[] args) {
    	System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    	System.out.println(largestTimeFromDigits(new int[]{5, 5, 5, 5}));
    }
}
