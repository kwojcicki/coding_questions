package project_euler;

public class q31 {

	/**
	 *
In England the currency is made up of pound, �, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, �1 (100p) and �2 (200p).
It is possible to make �2 in the following way:

1ף1 + 1�50p + 2�20p + 1�5p + 1�2p + 3�1p
How many different ways can �2 be made using any number of coins?
	 */
	public static void main(String[] args) {

		int target = 200;
		int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[] ways = new int[target+1];
		ways[0] = 1;
		 
		for (int i = 0; i < coinSizes.length; i++) {
		    for (int j = coinSizes[i]; j <= target; j++) {
		        ways[j] += ways[j - coinSizes[i]];
		    }
		}
		
		System.out.println(ways[200]);
	}
}
