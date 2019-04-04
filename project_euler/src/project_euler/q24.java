package project_euler;

import java.util.ArrayList;
import java.util.Collections;

public class q24 {

	/**
	 *
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
	 */
	public static void main(String[] args) {
		
		ArrayList<String> possibilities = new ArrayList<String>(4_000_000);
		char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		helper(possibilities, chars);
		Collections.sort(possibilities);
		System.out.println(possibilities.get(1_000_000 - 1));
		
	}
	
	public static void helper(ArrayList<String> x, char[] chars) {
		go(x, 0, chars.length - 1, chars);
	}
	
	public static void go(ArrayList<String> x, int start, int end, char[] chars) {
		if(start == end) {
			x.add(new String(chars));
		} else {
			for(int i = start; i <= end; i++) {
				char temp = chars[start];
				chars[start] = chars[i];
				chars[i] = temp;
				go(x, start + 1, end, chars);
				temp = chars[start];
				chars[start] = chars[i];
				chars[i] = temp;
				
			}
		}
	}
	

}
