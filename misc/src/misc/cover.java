package misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

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
		int[] input = new int[] {-7215, 1663, -5179, 1091, -542, 7868, -5687, 
				-1048, 7838, 4346, -2944, 3959, -2780, 1099, -9402, -7238, -8548, -2917, -3821, 295, 2713};
		recurse(all, curr, index, input);

		int maxScore = 0;
		ArrayList<Integer> maxScores = new ArrayList<Integer>();
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

			if(score > maxScore) {
				maxScore = Math.max(maxScore, score);
				maxScores = scores;
			}
			//System.out.println(a + " score: " + score);
		}

		System.out.println("max score: " + maxScore);

		String fileName = "C:\\Users\\krystian\\git\\coding_questions\\misc\\src\\misc\\input.txt";

		ArrayList<Long> numbers = new ArrayList<Long>();
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(i -> {
				for(String s: i.split(" ")) {
					numbers.add(Long.parseLong(s));
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.reverse(numbers);
		ArrayList<Long> scores = new ArrayList<Long>();

		Long c = 0L;
		for(Long i: numbers) {
			c += i;
			if(c > 0) {
				scores.add(c);
				c = 0L;
			}
		}
		
		scores.add(c);
		long score = 0;

		for(int i = 0; i < scores.size(); i++) {
			for(int j = i + 1; j < scores.size(); j++) {
				score += scores.get(i) * scores.get(j);	
			}
		}

		
		System.out.println(score);

		System.out.println(Arrays.stream(input).mapToLong(i -> i).sum());
		System.out.println(maxScores);
		System.out.println(scores);
		//System.out.println(numbers);
		System.out.println(numbers.size());
		System.out.println(numbers.parallelStream().mapToLong(i -> i).sum());
	}

}
