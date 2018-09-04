package misc;

public class painetrs_partition_problem {

	public static void main(String[] args) {
		System.out.println(solve(2, new int[] {10, 20, 30, 40}));
		System.out.println(solve(2, new int[] {10, 10, 10, 10}));
		System.out.println(solve(3, new int[] {10, 20, 60, 50, 30, 40}));
	}
	
	public static int solve(int k, int[] planks) {
		return solveHelper(k, planks.length - 1, planks);
	}
	
	private static int sum(int[] arr, int from, int to) {
	    int total = 0; 
	    for (int i = from; i <= to; i++) 
	        total += arr[i]; 
	    return total;  
	}
	
	public static int solveHelper(int k, int n, int[] planks) {
		System.out.println("step: n " + n + " k " + k);
		if(k == 1) {
			System.out.println("one worker: " + sum(planks, 0, n));
			return sum(planks, 0, n);
		}
		
		if(n <= 0) {
			System.out.println("one plank: " + planks[0]);
			return planks[0];
		}
		
		int best = Integer.MAX_VALUE;
		
		for(int i = n; i >= 0; i--) {
			System.out.println("Current work for worker: " + sum(planks, i, n));
			System.out.println("Work for other workers: " + solveHelper(k - 1, i - 1, planks));
			best = Math.min(best, Math.max( sum(planks, i, n), 
					solveHelper(k - 1, i - 1, planks)));
		}
		
		return best;
	}
	
}
