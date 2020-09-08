package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class moving_average_from_data_stream {
    /** Initialize your data structure here. */
    public moving_average_from_data_stream(int size) {
    	this.size = size;
    }
    
    private Deque<Integer> nums = new LinkedList<Integer>();
    private int size;
    private double sum = 0;
    
    public double next(int val) {
        nums.add(val);
        sum += val;
        if(nums.size() > size) {
        	sum -= nums.pop();
        }
        
        return sum / nums.size();
    }
}
