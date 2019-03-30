package project_euler;

public class q39 {

	/**
	 *
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p <= 1000, is the number of solutions maximised?
	 */
	public static void main(String[] args) {

		// counts duplicates but doesnt matter
		int maxSolutions = 0;
		int index = 0;
		for(int i = 3; i <= 1000; i++) {
			
			int solutions = 0;
			for(int a = 1; a < i; a++) {
				for(int b = 1; b < i; b++) {
					
					int temp = (int)Math.sqrt(a * a + b * b);
					if(a + b + temp == i && a * a + b * b - temp * temp == 0) {
						solutions++;
					}
					
				}
			}
			
			if(solutions > maxSolutions) {
				maxSolutions = solutions;
				index = i;
			}
			
		}
		
		System.out.println(index);
		System.out.println(maxSolutions);
	}
	

}
