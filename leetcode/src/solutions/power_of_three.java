package solutions;

public class power_of_three {
    public boolean isPowerOfThree(int n) {
    	if(n <= 0) return false;
    	double check = Math.log10(n) / Math.log10(3);
        return check == (int) check;
    }
}
