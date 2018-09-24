package misc;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		System.out.println(permutations(x, x.size() - 1));
	}
	
	public static <T> List<List<T>> permutations(List<T> x, int size){
		List<List<T>> lists = new ArrayList<List<T>>();
		if(size == -1) {
			lists.add(new ArrayList<T>());
			return lists;
		}
		
		List<List<T>> otherLists = permutations(x, size - 1);
		for(List<T> perm: otherLists) {
			List<T> temp = new ArrayList<T>(perm);
			temp.add(x.get(size));
			lists.add(temp);
		}
		
		return lists;
	}
	
}
