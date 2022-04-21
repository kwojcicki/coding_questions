package solutions;

public class design_hashset {
	class MyHashSet {

		boolean[] seen = new boolean[(int) (Math.pow(10, 6) + 1)];
	    public MyHashSet() {
	        
	    }
	    
	    public void add(int key) {
	        seen[key] = true;
	    }
	    
	    public void remove(int key) {
	        seen[key] = false;
	    }
	    
	    public boolean contains(int key) {
	    	return seen[key];
	    }
	}
}
