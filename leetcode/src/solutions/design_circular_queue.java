package solutions;

public class design_circular_queue {
	class MyCircularQueue {

		int size = 0;
		int[] b;
		int head = 0;
		int tail = 0;
	    public MyCircularQueue(int k) {
	    	b = new int[k];
	    }
	    
	    public boolean enQueue(int value) {
	        if(isFull()) return false;
	        size++;
	        b[tail] = value;
	        tail = (tail + 1) % b.length;
	        return true;
	    }
	    
	    public boolean deQueue() {
	        if(isEmpty()) return false;
	        size--;
            head = (head + 1) % b.length;
	        return true;
	    }
	    
	    public int Front() {
	        if(isEmpty()) return -1;
	        return b[head];
	    }
	    
	    public int Rear() {
	        if(isEmpty()) return -1;
	        return b[tail - 1 < 0 ? b.length - 1 : tail - 1];
	    }
	    
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
	    public boolean isFull() {
	        return size == b.length;
	    }
	}
}
