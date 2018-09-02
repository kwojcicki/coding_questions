package solutions;

public class counting_bits {
    public int[] countBits(int num) {
        int[] toReturn = new int[num + 1];
        for(int i = 1; i < toReturn.length; i++) {
        	toReturn[i] = toReturn[i/2] + (i % 2);
        }
        return toReturn;
    }
}
