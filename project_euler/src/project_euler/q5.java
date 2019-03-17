package project_euler;

public class q5 {

	/**
	 *2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	 */
	public static void main(String[] args) {
		int x = 2520;
		while(true) {
			
			boolean flag = true;
			for(int i = 2; i <= 20; i++) {
				if(x % i != 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.println(x);
				break;
			} 
			x++;
		}

	}

}
