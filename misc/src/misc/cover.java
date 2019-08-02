package misc;

import java.util.ArrayList;

public class cover {
	
	public static ArrayList<ArrayList<Integer>> clone(ArrayList<ArrayList<Integer>> curr){
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		
		for(ArrayList<Integer> a: curr) {
			ArrayList<Integer> n = new ArrayList<Integer>();
			for(int b: a) {
				n.add(b);
			}
			ret.add(n);
		}
		
		return ret;
	}
	
	public static void recurse(ArrayList<ArrayList<ArrayList<Integer>>> ret, ArrayList<ArrayList<Integer>> curr, 
			int index, int[] input){
		
		if(index == input.length) {
			ret.add(curr);
			return;
		}
		
		for(int i = index; i < input.length; i++) {
			ArrayList<ArrayList<Integer>> c = clone(curr);
			ArrayList<Integer> n = new ArrayList<Integer>();
			for(int j = index; j <= i; j++) {
				n.add(input[j]);
			}
			c.add(n);
			recurse(ret, c, i + 1, input);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<ArrayList<Integer>>> all = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> curr = new ArrayList<ArrayList<Integer>>();
		int index = 0;
		int[] input = new int[] {1, -2, 3, 4, -1, 0};
		recurse(all, curr, index, input);
		
		int maxScore = 0;
		for(ArrayList<ArrayList<Integer>> a: all) {
			
			ArrayList<Integer> scores = new ArrayList<Integer>();
			for(ArrayList<Integer> b: a) {
				scores.add(b.stream().mapToInt(i -> i).sum());
			}
			
			int score = 0;
			
			for(int i = 0; i < scores.size(); i++) {
				for(int j = i + 1; j < scores.size(); j++) {
					score += scores.get(i) * scores.get(j);	
				}
			}

			maxScore = Math.max(maxScore, score);
			System.out.println(a + " score: " + score);
		}
		
		System.out.println("max score: " + maxScore);
	}

}
