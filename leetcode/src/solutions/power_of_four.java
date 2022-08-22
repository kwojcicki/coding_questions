package solutions;

public class power_of_four {
    public boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        double result = Math.log(n) / Math.log(4);
        return  result == Math.floor( result ); 
    }
}
