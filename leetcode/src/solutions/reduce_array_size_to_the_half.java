package solutions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class reduce_array_size_to_the_half {
	public int minSetSize(int[] arr) {
    	int ret = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int[] freq = new int[arr.length + 1];
        
        for(int i: arr) {
        	count.compute(i, (k,v) -> v == null ? 1 : v + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
        	freq[entry.getValue()]++;
        }
        
        int size = 0;
        int ptr = freq.length - 1;
        while(size < arr.length / 2) {
        	while(freq[ptr] == 0) ptr--;
        	ret++;
        	size += ptr;
        	freq[ptr]--;
        }
        
        return ret;
    }
	
    public int minSetSize1(int[] arr) {
    	int ret = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i: arr) {
        	count.compute(i, (k,v) -> v == null ? 1 : v + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
        	q.add(entry.getValue());
        }
        
        int size = 0;
        while(size < arr.length / 2) {
        	size += q.poll();
        	ret++;
        }
        
        return ret;
    }
}
