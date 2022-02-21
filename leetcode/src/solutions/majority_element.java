package solutions;

public class majority_element {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int count = 0;
        
        for(int i: nums) {
        	if(i != maj && count == 0) {
        		maj = i; count = 1;
        	} else if(i != maj && count > 0) {
        		count--;
        	} else {
        		count++;
        	}
        }
        
        return maj;
    }
}
