package project_euler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class q22 {

	/**
	 *
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
	 */
	public static void main(String[] args) {

		String fileName = "./src/project_euler/p022_names.txt";
		TreeSet<String> sorted = new TreeSet<String>();
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			String x = stream.findFirst().get();
			Arrays.stream(x.replaceAll("\"", "").split(",")).forEach(i -> sorted.add(i));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		//System.out.println("");
		Iterator<String> iter = sorted.iterator();
		long sum = 0;
		for(int i = 1; iter.hasNext(); i++) {
			int localSum = 0;
			String x = iter.next();
			for(char c: x.toCharArray()) {
				localSum += c - 'A' + 1;
			}
			
			localSum *= i;
			System.out.println(x + " " + localSum + " " + i);
			sum += localSum;
		}
		
		
		System.out.println(sum);

	}
	
}
