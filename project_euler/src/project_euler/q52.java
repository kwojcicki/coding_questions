package project_euler;

public class q52 {

	/**
	 *
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
	 */
	public static void main(String[] args) {
		
		for(long i = 1; true; i++) {
			
			int[] i1 = count(i);
			int[] i2 = count(i * 2);
			int[] i3 = count(i * 3);
			int[] i4 = count(i * 4);
			int[] i5 = count(i * 5);
			int[] i6 = count(i * 6);
			
			
			if(!same(i1, i2) || 
					!same(i2, i3) ||
					!same(i3, i4) ||
					!same(i4, i5) ||
					!same(i5, i6)) {
				continue;
			}
			
			
			System.out.println(i);
			break;
		}
		
	}
	
	public static boolean same(int[] i1, int[] i2) {
		
		if(i1.length != i2.length) return false;
		
		for(int i = 0; i < i1.length; i++) {
			if(i1[i] != i2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] count(long i) {
		int[] toReturn = new int[10];
		
		for(char c: Long.toString(i).toCharArray()) {
			toReturn[c - '0']++;
		}
		
		return toReturn;
	}
}
