package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class smallest_integer_divisible_by_k {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        
        int r = 0;
        for (int n = 1; n <= K; n++) {
            r = (r * 10 + 1) % K;
            if (r == 0) return n;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
    	List<Parent> parents = new ArrayList<Parent>();
    	Parent p1 = new Parent();
    	Parent p2 = new Parent();
    	Parent p3 = new Parent();
    	
    	p1.getChildren().add(new Child(1));
    	p1.getChildren().add(new Child(2));
    	p2.getChildren().add(new Child(3));
    	p2.getChildren().add(new Child(4));
    	p3.getChildren().add(new Child(5));
    	p3.getChildren().add(new Child(6));
    	
    	parents.add(p1); parents.add(p2); parents.add(p3);
    	
    	List<Child> children = parents.stream().flatMap(i -> i.getChildren().stream()).collect(Collectors.toList());
    	
    	children.stream().forEach(System.out::println);
    }
}

class Child {
	public int x;
	public Child(int x) { this.x = x; };
	
	@Override
	public String toString() {
		return Integer.toString(x);
	}
}

class Parent {
	private List<Child> children = new ArrayList<>();
	
	public List<Child> getChildren(){
		return children;
	}
}