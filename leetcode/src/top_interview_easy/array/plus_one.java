package top_interview_easy.array;

import java.util.Arrays;

public class plus_one {
	
    public int[] plusOne(int[] digits) {
    	int[] newDigits = new int[digits.length];
        
        boolean carryOne = true;
        for(int i = digits.length - 1; i >= 0; i--) {
        	newDigits[i] = digits[i];
        	if(carryOne) {
        		newDigits[i] += 1;
        	}
        	
        	carryOne = false;
        	
        	if(newDigits[i] == 10) {
        		carryOne = true;
        		newDigits[i] = 0;
        	}
        }
        
        if(carryOne) {
        	int[] newDigits1 = new int[digits.length + 1];
        	newDigits1[0] = 1;
        	for (int i = 1; i < digits.length; i++) newDigits1[i + 1] = newDigits[i];
        	return newDigits1;
        }
        
        return newDigits;
    }
	
    public static void main(String[] args) {
    	plus_one s = new plus_one();
    	int[] a = new int[] {1,2,3};
    	System.out.println(Arrays.toString(s.plusOne(a)));
    	
    	a = new int[] {4,3,2,1};
    	System.out.println(Arrays.toString(s.plusOne(a)));
    	
    	a = new int[] {9, 9, 9};
    	System.out.println(Arrays.toString(s.plusOne(a)));
    }
}
