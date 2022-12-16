package solutions;

import java.util.Stack;

public class implement_queue_using_stacks {
	class MyQueue {
		private Stack<Integer> push = new Stack<>();
		private Stack<Integer> peek = new Stack<>();
		
	    public void push(int x) {
            push.add(x);
	    }
	    
	    public int pop() {
	        peek();
	        return peek.pop();
	    }
	    
	    public int peek() {
	        if(peek.isEmpty()) {
	        	while(!push.isEmpty()) {
	        		peek.push(push.pop());
	        	}
	        }
	        
	        return peek.peek();
	    }
	    
	    public boolean empty() {
	        return push.isEmpty() && peek.isEmpty();
	    }
	}
	
	class MyQueue1 {
		private int head = -1;
		private Stack<Integer> f = new Stack<>();
		private Stack<Integer> b = new Stack<>();
		
	    public MyQueue1() {
	        
	    }
	    
	    public void push(int x) {
            if(head == -1) head = x;
	        if(!b.isEmpty()) {
	        	while(!b.isEmpty()) {
	        		f.add(b.pop());
	        	}
	        }
	        f.add(x);
	    }
	    
	    public int pop() {
	        if(!f.isEmpty()) {
		        while(!f.isEmpty()) {
		        	b.add(f.pop());
		        }
	        }

        	int t = b.pop();
        	head = b.isEmpty() ? - 1 : b.peek();
        	return t;
	    }
	    
	    public int peek() {
	        return head;
	    }
	    
	    public boolean empty() {
	        return f.isEmpty() && b.isEmpty();
	    }
	}
}
