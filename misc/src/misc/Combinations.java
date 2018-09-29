package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		permute(x, output, 0);
		System.out.println(output);
	}

	public static void permute(List<Integer> arr, List<List<Integer>> output, int k){
		for(int i = k; i < arr.size(); i++){
			Collections.swap(arr, i, k);
			permute(arr, output, k+1);
			Collections.swap(arr, k, i);
		}
		if (k == arr.size() -1){
			System.out.println(Arrays.toString(arr.toArray()));
			List<Integer> answer = new ArrayList<Integer>();
			for(int i: arr) {
				answer.add(i);
			}
			output.add(answer);
		}
	}
	
	public static void nChooseK(List<Integer> arr, int k) {
		
	}
}
