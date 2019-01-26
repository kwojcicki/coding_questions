package top_interview_easy.math;

public class power_three {
	
    public boolean isPowerOfThree(int n) {
    	return Integer.toString(n, 3).matches("10*");
    }
    

}
