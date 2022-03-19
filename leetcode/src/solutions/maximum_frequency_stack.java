package solutions;

import java.util.HashMap;
import java.util.Stack;

public class maximum_frequency_stack {
	public class FreqStack {
		HashMap<Integer, Integer> freq = new HashMap<>();
	    HashMap<Integer, Stack<Integer>> m = new HashMap<>();
	    int max = 0;
		
	    public FreqStack() {
	        
	    }
	    
	    public void push(int val) {
	       int f = freq.getOrDefault(val, 0) + 1;
	       freq.put(val, f);
	       max = Math.max(max, f);
	       m.putIfAbsent(f, new Stack<>());
	       m.get(f).add(val);
	    }
	    
	    public int pop() {
	    	int ret = m.get(max).pop();
	    	
	    	freq.compute(ret, (k,v) -> v - 1);
	    	
	    	if(m.get(max).isEmpty()) {
	    		max--;
	    	}
	    	
	    	return ret;
	    }
	}

	
	public static void main(String[] args) {
		FreqStack fs = new maximum_frequency_stack().new FreqStack();
		fs.push(5);
		fs.push(7);
		fs.push(5);
		fs.push(7);
		fs.push(4);
		fs.push(5);
		System.out.println(fs.pop());
		System.out.println(fs.pop());
		System.out.println(fs.pop());
		System.out.println(fs.pop());
	}
}
