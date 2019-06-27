package top_interview_medium.others;

import java.util.Arrays;

public class daily_temperatures {
	public int[] dailyTemperatures(int[] temperatures) {
	    int[] stack = new int[temperatures.length];
	    int top = -1;
	    int[] ret = new int[temperatures.length];
	    for(int i = 0; i < temperatures.length; i++) {
	    	System.out.println("outter: " + i);
	        while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
	        	System.out.println("inner");
	            int idx = stack[top--];
	            ret[idx] = i - idx;
	        }
	        stack[++top] = i;
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new daily_temperatures().dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
	}
}
