package solutions;

public class arranging_coins {
    public int arrangeCoins(int n) {
    	double n2 = n;
        return (int) (( (-1) + Math.sqrt(1 - 4 * -1 * 2 * n2))/ 2 * 1);
    }
    
    public static void main(String[] args) {
    	System.out.println(new arranging_coins().arrangeCoins(1804289383));
    }
}
