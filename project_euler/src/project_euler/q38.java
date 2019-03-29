package project_euler;

public class q38 {

	/**
	 *
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
	 */
	public static void main(String[] args) {

		long max = 0;
		String sum = "";
		
		outerloop:
		for(int i = 1; i < 100_000; i++) {
			sum = i + "";
			sum += (i * 2) + "";
			for(int j = 3; sum.length() < 9; j++) {
				sum += (i * j) + "";
			}
			
			if(sum.length() == 9 && sum.indexOf('0') < 0) {
				
				boolean[] seen = new boolean[9];
				for(char c: sum.toCharArray()) {
					if(seen[c - '1']) {
						continue outerloop;
					}
					seen[c - '1'] = true;
				}
				
				max = Math.max(max, Integer.parseInt(sum));
			}
		}
		
		System.out.println(max);
	}
	

}
