package solutions;

public class jewels_and_stones {
    public int numJewelsInStones(String J, String S) {
    	int total = 0;
        for(char c: S.toCharArray()) {
        	if(J.indexOf(c) != -1) {
        		total++;
        	}
        }
        return total;
    }
}
