package solutions.strings.game_of_thrones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
    	int[] chars = new int[26];
    	
    	s.chars().forEach(i -> chars[i - 'a']++);
    	
    	boolean flag = false;
    	for(int i: chars) {
    		if(i%2 != 0) {
    			if(flag) {
    				return "NO";
    			}
    			flag = true;
    		}
    	}
    	
    	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
