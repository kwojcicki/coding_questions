package project_euler;

public class q14 {

	/**
	 *
The following iterative sequence is defined for the set of positive integers:

n -> n/2 (n is even)
n -> 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
	 */
	public static void main(String[] args) {

		int maxChain = 0;
		long maxChainNumber = 0;
		int current = 3;
		long currentSequence = 3;
		
		while(current < 1_000_000) {
			currentSequence = current;
			int currentChain = 0;
			
			while(currentSequence != 1) {
				currentChain++;
				if(currentSequence % 2 == 0) {
					currentSequence = currentSequence/2;
				} else {
					currentSequence = currentSequence * 3 + 1;
				}
			}
			//System.out.println(current);
			
			if(currentChain > maxChain) {
				maxChainNumber = current;
				maxChain = currentChain;
			}
			
			current++;
		}
		
		System.out.println(maxChainNumber);

	}
}
