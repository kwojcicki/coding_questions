package project_euler;

public class q3 {

	/**
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

		By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	 * @param args
	 */
	public static void main(String[] args) {
		Long total = new Long(0);
		int c1 = 1;
		int c2 = 2;
		while(c1 < 4000000) {
			int temp = c1 + c2;
			c1 = c2;
			c2 = temp;
			if(c1 % 2 == 0 && c1 < 4000000) {
				total += c1;
			}
		}
		
		System.out.println(total);
	}

}