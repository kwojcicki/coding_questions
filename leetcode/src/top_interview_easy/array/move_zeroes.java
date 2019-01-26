package top_interview_easy.array;

import java.util.Arrays;

public class move_zeroes {
	
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        
        int positionZero = 0;
        for(int num: nums) {
        	if(num != 0) {
        		nums[positionZero] = num;
        		positionZero++;
        	}
        }
        
        while(positionZero < nums.length) {
        	nums[positionZero] = 0;
        	positionZero++;
        }
    }
	
    public static void main(String[] args) {
    	move_zeroes s = new move_zeroes();
    	int[] a = new int[] {0,1,0,3,12};
    	
    	s.moveZeroes(a);
    	System.out.println(Arrays.toString(a));
    }
}
