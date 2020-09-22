package solutions;

import java.util.ArrayList;
import java.util.List;

public class majority_element_ii {
    public List<Integer> majorityElement(int[] nums) {
        int counter1 = 0, majority1 = 0;
        int counter2 = 0, majority2 = 0;
        
        List<Integer> ret = new ArrayList<>();
        
        
        for(int i: nums) {
        	if(i == majority1) {
        		counter1++;
        	} else if(i == majority2) {
        		counter2++;
        	} else if(counter1 == 0) {
        		counter1 = 1;
        		majority1 = i;
        	} else if(counter2 == 0) {
        		counter2 = 1;
        		majority2 = i;
        	} else {
        		counter1--;
        		counter2--;
        	}
        }
        
        counter1 = 0; counter2 = 0;
        for(int i: nums) {
        	if(i == majority1) {
        		counter1++;
        	} else if(i == majority2) {
        		counter2++;
        	}
        }
        
        if(counter1 > nums.length / 3) ret.add(majority1);
        if(counter2 > nums.length / 3) ret.add(majority2);
        return ret;
    }
}
