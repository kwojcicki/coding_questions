package misc;

import java.util.ArrayList;
import java.util.List;

public class lists {
	public static void main(String[] args) {
		List<Object> x1 = new ArrayList<>();
		x1.add(1);
		x1.add(2);
		
		List<Integer> x2 = new ArrayList<Integer>();
		x1.forEach(i -> x2.add((Integer)i));
		
		List<Integer> x3 = (List<Integer>)(List<?>) x1;
		
		System.out.println(x2);
	}
}
