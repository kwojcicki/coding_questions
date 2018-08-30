package solutions.data_structures.jesse_and_cookies;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        
    	int operations = 0;
    	Queue<Integer> queue = new PriorityQueue<Integer>();
    	
    	Arrays.stream(A).forEach(i -> queue.add(i));
    	
    	while(queue.size() >=2 && queue.peek() < k) {
    		int cookie1 = queue.poll();
    		int cookie2 = queue.poll();
    		
    		queue.add(cookie1 + 2 * cookie2);
    		operations++;
    	}
    	
    	return queue.peek() < k ? -1 : operations;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}